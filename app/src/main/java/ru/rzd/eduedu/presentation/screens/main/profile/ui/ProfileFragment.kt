package ru.rzd.eduedu.presentation.screens.main.profile.ui

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import org.jetbrains.anko.support.v4.toast
import ru.rzd.eduedu.App
import ru.rzd.eduedu.R
import ru.rzd.eduedu.presentation.global.base.BaseFragment
import ru.rzd.eduedu.presentation.screens.main.profile.mvp.ProfilePresenter
import ru.rzd.eduedu.presentation.screens.main.profile.mvp.ProfileView
import javax.inject.Inject

class ProfileFragment : BaseFragment(), ProfileView, View.OnClickListener {
    override val layoutRes: Int = R.layout.fragment_profile

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    @ProvidePresenter fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.componentManager.appComponent
            .profileComponentBuilder()
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        setupToolbar(getString(R.string.menu_profile))
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.signInButton -> presenter.onSignInClicked()
        }
    }

    override fun showProgress(show: Boolean) {
//        profileProgress.isVisible = show // TODO
    }

    override fun showContentLayout(show: Boolean) {
//        profileContainer.isVisible = show  // TODO
    }

    override fun showError(show: Boolean, message: String) {
        if (show) toast("Ошбика загрузки данных")
    }

    override fun onBackPressed() = presenter.onBackPressed()
}