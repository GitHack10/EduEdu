package ru.rzd.eduedu.di.global

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.rzd.eduedu.App
import ru.rzd.eduedu.di.global.modules.AppModule
import ru.rzd.eduedu.di.global.modules.NavigationModule
import ru.rzd.eduedu.di.global.modules.NetworkModule
import ru.rzd.eduedu.di.screens.home.HomeComponent
import ru.rzd.eduedu.di.screens.main.MainComponent
import ru.rzd.eduedu.di.screens.notifications.NotificationsComponent
import ru.rzd.eduedu.di.screens.profile.ProfileComponent
import ru.rzd.eduedu.presentation.global.base.BaseActivity
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        NavigationModule::class,
        NetworkModule::class
    ]
)
@Singleton
interface AppComponent {
    fun inject(app: App)
    fun inject(activity: BaseActivity)

    fun mainComponentBuilder(): MainComponent.Builder
    fun homeComponentBuilder(): HomeComponent.Builder
    fun notificationComponentBuilder(): NotificationsComponent.Builder
    fun profileComponentBuilder(): ProfileComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance fun context(context: Context): Builder

        fun build(): AppComponent
    }
}