package ru.rzd.eduedu.data.global.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.rzd.eduedu.domain.global.models.Restaurant

interface EduEduApi {

    @GET("/api/")
    fun getRestaurants(
        @Query("api_key") apiKey: String = "fdsoanmvafnlasdmflassadklksldao",
        @Query("key") key: String = "mainMenu"
    ): Single<List<Restaurant>>
}