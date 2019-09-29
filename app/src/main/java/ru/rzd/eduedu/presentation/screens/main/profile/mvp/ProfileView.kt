package ru.rzd.eduedu.presentation.screens.main.profile.mvp

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileView : MvpView {
    fun showProgress(show: Boolean)
    fun showContentLayout(show: Boolean)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(show: Boolean, message: String = "")
}