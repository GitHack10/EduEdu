package ru.rzd.eduedu.data.screens

import io.reactivex.Single
import ru.rzd.eduedu.data.global.network.EduEduApi
import ru.rzd.eduedu.di.global.scopes.FragmentScope
import ru.rzd.eduedu.di.screens.home.HomeScope
import ru.rzd.eduedu.domain.global.commons.io
import ru.rzd.eduedu.domain.global.models.Restaurant
import ru.rzd.eduedu.domain.global.repositories.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: EduEduApi
) : HomeRepository {

    override fun getRestaurants(): Single<List<Restaurant>> = api.getRestaurants()
        .subscribeOn(io)
}