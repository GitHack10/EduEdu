package ru.rzd.eduedu.presentation.screens.main.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.newTask
import ru.rzd.eduedu.App
import ru.rzd.eduedu.R
import ru.rzd.eduedu.presentation.global.base.BaseActivity
import ru.rzd.eduedu.presentation.global.base.BottomBarListener
import ru.rzd.eduedu.presentation.screens.main.mvp.MainPresenter
import ru.rzd.eduedu.presentation.screens.main.mvp.MainView
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView, BottomBarListener {
    override val container = R.id.main_container

    @Inject
    override lateinit var navigatorHolder: NavigatorHolder

    override var navigator: Navigator? = object : SupportAppNavigator(this, container) {
        override fun activityBack() {
            super.activityBack()
        }
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.componentManager.mainComponent = App.componentManager.appComponent
            .mainComponentBuilder()
            .build()
        App.componentManager.mainComponent?.inject(this)
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavView.setOnNavigationItemSelectedListener {
            setBottomMenuCheckable(true)

            when (it.itemId) {
                R.id.navigation_home -> {
                    presenter.onHomeClicked()
                    true
                }

                R.id.navigation_profile -> {
                    presenter.onProfileClicked()
                    true
                }

                else -> false
            }
        }

        // Необходимо для первого запуска активности (НЕ приложения), т.к. по умолчанию отображается рекламный экран
        setBottomMenuCheckable(true)
    }

    override fun showBar(show: Boolean) {
        bottomNavView.isVisible = show
    }

    override fun onItemChecked(item: BottomBarListener.ITEM) {
        setBottomMenuCheckable(true)
        bottomNavView.menu.getItem(item.index).isChecked = true
    }

    /** Устанавливает выделение выбранного пункта в нижнем меню. */
    private fun setBottomMenuCheckable(checkable: Boolean) {
        bottomNavView.menu.setGroupCheckable(0, checkable, true)
    }

    override fun onBackPressed() = currentFragment?.onBackPressed() ?: presenter.onBackPressed()

    companion object {
        fun createIntent(context: Context, userRegistered: Boolean = false) =
            Intent(context, MainActivity::class.java).apply {
                if (userRegistered) {
                    newTask()
                    clearTask()
                }
            }

        const val HOME_TAB = 1
        const val PROFILE_TAB = 2
    }
}