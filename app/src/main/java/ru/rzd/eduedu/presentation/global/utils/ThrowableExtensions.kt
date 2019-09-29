package ru.rzd.eduedu.presentation.global.utils

import ru.rzd.eduedu.R
import ru.rzd.eduedu.presentation.global.resourcemanager.ResourceManager
import java.io.IOException

fun Throwable.userMessage(resourceManager: ResourceManager): String = when (this) {
    is IOException -> resourceManager.getString(R.string.error_network)
    else -> resourceManager.getString(R.string.error_unknown)
}