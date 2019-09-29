package ru.rzd.eduedu.presentation.screens.main.home.mvp

import com.arellomobile.mvp.InjectViewState
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import ru.rzd.eduedu.R
import ru.rzd.eduedu.di.global.scopes.FragmentScope
import ru.rzd.eduedu.di.screens.home.HomeScope
import ru.rzd.eduedu.domain.global.models.Restaurant
import ru.rzd.eduedu.domain.screens.HomeInteractor
import ru.rzd.eduedu.presentation.global.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
@HomeScope
class HomePresenter @Inject constructor(
    private val router: Router,
    private val interactor: HomeInteractor
) : BasePresenter<HomeView>(router) {

    private val list: List<Restaurant> = ArrayList()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getRestaurants()
    }

    private fun getRestaurants() {
//        (list as ArrayList).add(
//            Restaurant(
//            1,
//            "Burger King",
//            R.drawable.ic_burger_king,
//            R.drawable.image_banner_bk,
//            "Fast Food",
//            "доступно для заказа в течение 30 мин."
//            )
//        )
//
//        list.add(
//            Restaurant(
//                1,
//                "McDonald’s",
//                R.drawable.ic_mcdonalds,
//                R.drawable.image_banner_mc,
//                "Fast Food",
//                "доступно для заказа в течение 50 мин."
//            )
//        )

//        (list as ArrayList).add(
//            Restaurant(
//                1,
//                "KFC",
//                R.drawable.ic_burger_king,
//                R.drawable.image_banner_bk,
//                "Fast Food",
//                "доступно для заказа в течение 1 часа"
//            )
//        )

        subscriptions += interactor.getRestaurants()
            .doOnSubscribe {
                viewState.showError(false)
                viewState.showContentLayout(false)
                viewState.showProgress(true)
            }
            .doAfterTerminate { viewState.showProgress(false) }
            .subscribeBy(
                onSuccess = {
                    viewState.showContentLayout(true)
                    viewState.showError(false)
                    viewState.showRestaurants(it)
                },
                onError = {
                    viewState.showError(true)
                    viewState.showContentLayout(false)
                }
            )
    }

    fun onRestaurantClicked() {
        // TODO
    }
}