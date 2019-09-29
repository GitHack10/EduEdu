package ru.rzd.eduedu.presentation.screens.main.mvp

import com.arellomobile.mvp.InjectViewState
import ru.rzd.eduedu.di.global.scopes.ActivityScope
import ru.rzd.eduedu.presentation.global.Screens
import ru.rzd.eduedu.presentation.global.base.BasePresenter
import ru.rzd.eduedu.presentation.screens.main.ui.MainActivity.Companion.HOME_TAB
import ru.rzd.eduedu.presentation.screens.main.ui.MainActivity.Companion.NOTIFICATIONS_TAB
import ru.rzd.eduedu.presentation.screens.main.ui.MainActivity.Companion.PROFILE_TAB
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
@ActivityScope
class MainPresenter @Inject constructor(
    private val router: Router
): BasePresenter<MainView>(router) {

    private var selectedScreen = 0

    override fun onFirstViewAttach() = router.newRootScreen(Screens.HomeScreen) // По умолчанию

    fun onHomeClicked() {
        if (selectedScreen != HOME_TAB) {
            router.newRootScreen(Screens.HomeScreen)
        }
        selectedScreen = HOME_TAB
    }

    fun onNotificationsClicked() {
        if (selectedScreen != NOTIFICATIONS_TAB) {
            router.newRootScreen(Screens.NotificationsScreen)
        }
        selectedScreen = NOTIFICATIONS_TAB
    }

    fun onProfileClicked() {
        if (selectedScreen != PROFILE_TAB) {
//            router.newRootScreen(Screens.ProfileScreen)
        }
        selectedScreen = PROFILE_TAB
    }
}