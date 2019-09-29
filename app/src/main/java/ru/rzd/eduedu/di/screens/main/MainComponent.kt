package ru.rzd.eduedu.di.screens.main

import dagger.Subcomponent
import ru.rzd.eduedu.di.global.scopes.ActivityScope
import ru.rzd.eduedu.presentation.screens.main.ui.MainActivity

@Subcomponent
@MainScope
interface MainComponent {
    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): MainComponent
    }
}