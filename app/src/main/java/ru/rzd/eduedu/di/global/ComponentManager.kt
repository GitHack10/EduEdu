package ru.rzd.eduedu.di.global

import android.content.Context
import ru.rzd.eduedu.di.screens.main.MainComponent

class ComponentManager(private val context: Context) {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(context)
            .build()
    }

    var mainComponent: MainComponent? = null
}