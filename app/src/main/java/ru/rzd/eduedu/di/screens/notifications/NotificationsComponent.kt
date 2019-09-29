package ru.rzd.eduedu.di.screens.notifications

import dagger.Subcomponent
import ru.rzd.eduedu.di.global.scopes.FragmentScope
import ru.rzd.eduedu.presentation.screens.main.notifications.ui.NotificationsFragment

@Subcomponent
@FragmentScope
interface NotificationsComponent {
    fun inject(fragment: NotificationsFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): NotificationsComponent
    }
}