package ru.rzd.eduedu.domain.screens

import io.reactivex.Single
import ru.rzd.eduedu.data.screens.HomeRepositoryImpl
import ru.rzd.eduedu.domain.global.commons.ui
import ru.rzd.eduedu.domain.global.models.Restaurant
import ru.rzd.eduedu.domain.global.repositories.HomeRepository
import javax.inject.Inject

/** Created by Kamil Abdulatipov on 27.09.2019.
 *  telegram: @mr_geeek
 */

class HomeInteractor @Inject constructor(
    private val homeRepository: HomeRepositoryImpl
) {

    fun getRestaurants(): Single<List<Restaurant>> = homeRepository.getRestaurants()
        .observeOn(ui)
}