package ru.rzd.eduedu.presentation.screens.main.notifications.mvp

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.rzd.eduedu.domain.global.models.Notification

@StateStrategyType(AddToEndSingleStrategy::class)
interface NotificationsView : MvpView {
    fun showProgress(show: Boolean)
    fun showEmptyList(show: Boolean)
    fun showContentLayout(show: Boolean)

    fun showNotifications(notifications: List<Notification>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(show: Boolean, message: String = "")
}