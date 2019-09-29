package ru.rzd.eduedu.presentation.screens.main.notifications.mvp

import com.arellomobile.mvp.InjectViewState
import ru.rzd.eduedu.di.global.scopes.FragmentScope
import ru.rzd.eduedu.presentation.global.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
@FragmentScope
class NotificationsPresenter @Inject constructor(
    private val router: Router
) : BasePresenter<NotificationsView>(router) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getNotifications()
    }

    private fun getNotifications() {
        viewState.showEmptyList(true)
    }

    fun onNotificationClicked() {
        // TODO
    }
}