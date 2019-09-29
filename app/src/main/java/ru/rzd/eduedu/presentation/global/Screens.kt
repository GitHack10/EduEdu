package ru.rzd.eduedu.presentation.global

import ru.rzd.eduedu.presentation.screens.main.home.ui.HomeFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

/** Created by Kamil Abdulatipov on 27.09.2019.
 *  telegram: @mr_geeek
 */

object Screens {

    object SignIn : SupportAppScreen()

    object HomeScreen : SupportAppScreen() {
        override fun getFragment() = HomeFragment()
    }

    object BasketScreen : SupportAppScreen()

    object NotificationScreen : SupportAppScreen()

    object ProfileScreen : SupportAppScreen()
}