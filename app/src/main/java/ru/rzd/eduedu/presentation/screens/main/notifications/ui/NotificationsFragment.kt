package ru.rzd.eduedu.presentation.screens.main.notifications.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_notification.*
import kotlinx.android.synthetic.main.loading_notification_empty.*
import org.jetbrains.anko.support.v4.toast
import ru.rzd.eduedu.App
import ru.rzd.eduedu.R
import ru.rzd.eduedu.domain.global.models.Notification
import ru.rzd.eduedu.presentation.global.base.BaseFragment
import ru.rzd.eduedu.presentation.screens.main.notifications.mvp.NotificationsPresenter
import ru.rzd.eduedu.presentation.screens.main.notifications.mvp.NotificationsView
import javax.inject.Inject

class NotificationsFragment : BaseFragment(), NotificationsView, View.OnClickListener {
    override val layoutRes: Int = R.layout.fragment_notification

    @Inject
    @InjectPresenter
    lateinit var presenter: NotificationsPresenter

    @ProvidePresenter fun providePresenter() = presenter

    /*private val restaurantAdapter by lazy {
        NotificationAdapter(ArrayList()) {
            presenter.onNotificationClicked()
        }
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        App.componentManager.appComponent
            .notificationComponentBuilder()
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        setupToolbar(getString(R.string.menu_notifications))

        notificationProgress.isVisible = false  // TODO
//        notificationRecyclerView.adapter = notificationAdapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }

    override fun showProgress(show: Boolean) {
        notificationProgress.isVisible = show
    }

    override fun showEmptyList(show: Boolean) {
        loadingNotificationsEmptyLayout.isVisible = show
    }

    override fun showContentLayout(show: Boolean) {
        notificationRecyclerView.isVisible = show
    }

    override fun showError(show: Boolean, message: String) {
        if (show) toast("Ошбика загрузки данных")
    }

    override fun showNotifications(notifications: List<Notification>) {
//        notificationAdapter.list = notifications
//        notificationAdapter.submitList(notifications)
    }

    override fun onBackPressed() = presenter.onBackPressed()
}