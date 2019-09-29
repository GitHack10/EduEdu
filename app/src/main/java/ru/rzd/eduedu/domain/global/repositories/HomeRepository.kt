package ru.rzd.eduedu.domain.global.repositories

import io.reactivex.Single
import ru.rzd.eduedu.domain.global.models.Restaurant

interface HomeRepository {
    fun getRestaurants(): Single<List<Restaurant>>
}