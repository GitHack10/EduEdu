package ru.rzd.eduedu.presentation.global.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import ru.rzd.eduedu.presentation.global.navigation.FlowRouter

abstract class FlowPresenter<T : MvpView>(protected val router: FlowRouter? = null) :
    MvpPresenter<T>() {

    protected val subscription = CompositeDisposable()

    override fun onDestroy() {
        subscription.dispose()
        super.onDestroy()
    }

    open fun onBackPressed() {
        router?.exitFlow()
    }
}