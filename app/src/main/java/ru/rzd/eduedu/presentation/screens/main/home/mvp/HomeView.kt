package ru.rzd.eduedu.presentation.screens.main.home.mvp

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.rzd.eduedu.domain.global.models.Restaurant

@StateStrategyType(AddToEndSingleStrategy::class)
interface HomeView : MvpView {
    fun showProgress(show: Boolean)
    fun showContentLayout(show: Boolean)
    fun showRestaurants(restaurants: List<Restaurant>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(show: Boolean, message: String = "")
}