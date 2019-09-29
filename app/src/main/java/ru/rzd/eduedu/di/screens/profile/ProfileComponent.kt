package ru.rzd.eduedu.di.screens.profile

import dagger.Subcomponent
import ru.rzd.eduedu.di.global.scopes.FragmentScope
import ru.rzd.eduedu.presentation.screens.main.home.ui.HomeFragment
import ru.rzd.eduedu.presentation.screens.main.profile.ui.ProfileFragment

@Subcomponent
@FragmentScope
interface ProfileComponent {
    fun inject(fragment: ProfileFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ProfileComponent
    }
}