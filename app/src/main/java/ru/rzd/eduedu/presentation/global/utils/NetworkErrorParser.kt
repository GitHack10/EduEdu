package ru.rzd.eduedu.presentation.global.utils

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import ru.rzd.eduedu.R
import ru.rzd.eduedu.domain.global.models.ApiError
import ru.rzd.eduedu.presentation.global.resourcemanager.ResourceManager
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkErrorParser @Inject constructor(
    retrofit: Retrofit,
    private val resourceManager: ResourceManager
) {

    private val converter: Converter<ResponseBody, ApiError> =
        retrofit.responseBodyConverter(ApiError::class.java, emptyArray<Annotation>())

    fun parseMessage(error: HttpException): String {
        val apiError = try {
            error.response().errorBody()?.let { converter.convert(it) }
                ?: ApiError(resourceManager.getString(R.string.error_network_get_response))
        } catch (e: IOException) {
            ApiError(resourceManager.getString(R.string.error_network_convert_response))
        }

        val errors = apiError.errors
        return if (!errors.isNullOrEmpty()) errors.first().message else apiError.message
    }
}