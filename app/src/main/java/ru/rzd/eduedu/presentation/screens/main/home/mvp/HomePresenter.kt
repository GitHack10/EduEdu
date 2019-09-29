package ru.rzd.eduedu.presentation.screens.main.home.mvp

import com.arellomobile.mvp.InjectViewState
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import ru.rzd.eduedu.di.global.scopes.FragmentScope
import ru.rzd.eduedu.domain.screens.HomeInteractor
import ru.rzd.eduedu.presentation.global.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
@FragmentScope
class HomePresenter @Inject constructor(
    private val router: Router,
    private val interactor: HomeInteractor
) : BasePresenter<HomeView>(router) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getRestaurants()
    }

    private fun getRestaurants() {
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