package ru.rzd.eduedu.presentation.global

import ru.rzd.eduedu.presentation.screens.main.home.ui.HomeFragment
import ru.rzd.eduedu.presentation.screens.main.notifications.ui.NotificationsFragment
import ru.rzd.eduedu.presentation.screens.main.profile.ui.ProfileFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

/** Created by Kamil Abdulatipov on 27.09.2019.
 *  telegram: @mr_geeek
 */

object Screens {

    object SignIn : SupportAppScreen()

    object HomeScreen : SupportAppScreen() {
        override fun getFragment() = HomeFragment()
    }

    object NotificationsScreen : SupportAppScreen() {
        override fun getFragment() = NotificationsFragment()
    }

    object ProfileScreen : SupportAppScreen() {
        override fun getFragment() = ProfileFragment()
    }

    object BasketScreen : SupportAppScreen()
}