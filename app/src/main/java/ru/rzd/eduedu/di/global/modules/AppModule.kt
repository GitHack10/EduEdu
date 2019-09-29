package ru.rzd.eduedu.di.global.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.rzd.eduedu.presentation.global.resourcemanager.AndroidResourceManager
import ru.rzd.eduedu.presentation.global.resourcemanager.ResourceManager
import ru.rzd.eduedu.presentation.global.utils.ErrorHandler
import ru.rzd.eduedu.presentation.global.utils.NetworkErrorParser
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun provideResourceManager(resourceManager: AndroidResourceManager): ResourceManager

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideErrorHandler(
            router: Router,
            networkErrorParser: NetworkErrorParser,
            resourceManager: ResourceManager
        ) = ErrorHandler(router, networkErrorParser, resourceManager)
    }
}