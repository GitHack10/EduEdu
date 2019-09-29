package ru.rzd.eduedu.presentation.screens.main.home.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.toast
import ru.rzd.eduedu.App
import ru.rzd.eduedu.R
import ru.rzd.eduedu.domain.global.models.Restaurant
import ru.rzd.eduedu.presentation.global.base.BaseFragment
import ru.rzd.eduedu.presentation.screens.main.home.mvp.HomePresenter
import ru.rzd.eduedu.presentation.screens.main.home.mvp.HomeView
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeView, View.OnClickListener {
    override val layoutRes: Int = R.layout.fragment_home

    @Inject
    @InjectPresenter
    lateinit var presenter: HomePresenter

    @ProvidePresenter fun providePresenter() = presenter

    private val restaurantAdapter by lazy {
        RestaurantAdapter(ArrayList()) {
            presenter.onRestaurantClicked()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.componentManager.appComponent
            .homeComponentBuilder()
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        setupToolbar(getString(R.string.menu_home))
        homeRecyclerView.adapter = restaurantAdapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }

    override fun showProgress(show: Boolean) {
        homeProgress.isVisible = show
    }

    override fun showContentLayout(show: Boolean) {
        homeRecyclerView.isVisible = show
    }

    override fun showError(show: Boolean, message: String) {
        if (show) toast("Ошбика загрузки данных")
    }

    override fun showRestaurants(restaurants: List<Restaurant>) {
        restaurantAdapter.list = restaurants
        restaurantAdapter.submitList(restaurants)
    }

    override fun onBackPressed() = presenter.onBackPressed()
}