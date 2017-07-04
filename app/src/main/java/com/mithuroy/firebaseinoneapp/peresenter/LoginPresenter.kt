package com.mithuroy.firebaseinoneapp.peresenter

import com.mithuroy.firebaseinoneapp.R
import com.mithuroy.firebaseinoneapp.domain.DomainCallback
import com.mithuroy.firebaseinoneapp.domain.LoginService
import com.mithuroy.firebaseinoneapp.view.LoginView

/**
 * Created by Mithu on July'04 2017
 */

class LoginPresenter(val view: LoginView, val service: LoginService) : DomainCallback {

    companion object {
        val PASSWORD_MIN_LIMIT = 8
    }

    fun onLoginClicked() {
        val emailAddress: String = view.getEmailAddress()
        val password: String = view.getPassword()

        if (emailAddress.isEmpty()) {
            view.showEmailError(R.string.error_email)
            return
        }

        if (password.isEmpty()) {
            view.showPasswordError(R.string.error_password)
            return
        }

        if (password.length < PASSWORD_MIN_LIMIT - 1) {
            view.showPasswordError(R.string.error_password_character_limit)
            return
        }

        view.isLoading()

        service.startLoginProcess(view, this)
    }

    override fun onSuccess() {
        view.onLoginSuccess(R.string.success_login)
    }

    override fun onFailure(errorCode: String) {
        view.onLoginFailure(R.string.error_general)
    }
}