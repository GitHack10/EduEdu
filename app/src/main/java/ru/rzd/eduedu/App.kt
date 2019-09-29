package ru.rzd.eduedu

import android.annotation.SuppressLint
import android.content.Context
import android.support.multidex.MultiDexApplication
import com.arellomobile.mvp.MvpFacade
import com.jakewharton.threetenabp.AndroidThreeTen
import ru.rzd.eduedu.di.global.ComponentManager
import timber.log.Timber

class App : MultiDexApplication() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        initDI(base)
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        MvpFacade.init()
        initTimber()
    }

    private fun initDI(context: Context) {
        componentManager = ComponentManager(context)
        componentManager.appComponent.inject(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var componentManager: ComponentManager
    }
}