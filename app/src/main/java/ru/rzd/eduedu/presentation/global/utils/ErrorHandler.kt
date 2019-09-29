package ru.rzd.eduedu.presentation.global.utils

import com.crashlytics.android.Crashlytics
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import ru.rzd.eduedu.presentation.global.Screens
import ru.rzd.eduedu.presentation.global.resourcemanager.ResourceManager
import ru.terrakok.cicerone.Router
import timber.log.Timber

class ErrorHandler(
    private val router: Router,
    private val networkErrorParser: NetworkErrorParser,
    private val resourceManager: ResourceManager
) {

    fun proceed(error: Throwable, messageListener: (String) -> Unit) {
        Timber.e(error)
        if (error is HttpException) {
            when (error.code()) {
                401 -> signOut() // Токен истек или не существует
                else -> messageListener(networkErrorParser.parseMessage(error))
            }
        } else {
            messageListener(error.userMessage(resourceManager))

            Crashlytics.logException(error)
        }
    }

    private fun signOut() {
        router.replaceScreen(Screens.SignIn)
    }
}