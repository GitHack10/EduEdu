package ru.rzd.eduedu.presentation.screens.main.profile.mvp

import com.arellomobile.mvp.InjectViewState
import ru.rzd.eduedu.di.global.scopes.FragmentScope
import ru.rzd.eduedu.presentation.global.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
@FragmentScope
class ProfilePresenter @Inject constructor(
    private val router: Router
) : BasePresenter<ProfileView>(router) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun onSignInClicked() {

    }
}