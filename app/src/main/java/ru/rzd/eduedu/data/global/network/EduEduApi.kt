package ru.rzd.eduedu.data.global.network

import io.reactivex.Single
import retrofit2.http.GET
import ru.rzd.eduedu.domain.global.models.Restaurant

interface EduEduApi {

    @GET("5d8f7c153200005d00adec74")
    fun getRestaurants(): Single<List<Restaurant>>
}