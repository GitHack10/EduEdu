package ru.rzd.eduedu.di.screens.home

import dagger.Subcomponent
import ru.rzd.eduedu.di.global.scopes.FragmentScope
import ru.rzd.eduedu.presentation.screens.main.home.ui.HomeFragment

@Subcomponent
@FragmentScope
interface HomeComponent {
    fun inject(fragment: HomeFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): HomeComponent
    }
}