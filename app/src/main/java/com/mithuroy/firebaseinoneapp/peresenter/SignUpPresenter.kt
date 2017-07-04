package com.mithuroy.firebaseinoneapp.peresenter

import com.mithuroy.firebaseinoneapp.R
import com.mithuroy.firebaseinoneapp.domain.SignUpCallBack
import com.mithuroy.firebaseinoneapp.domain.SignUpService
import com.mithuroy.firebaseinoneapp.view.SignUpView

/**
 * Created by Mithu on June'26 2017
 */

class SignUpPresenter(val view: SignUpView, val service: SignUpService) : SignUpCallBack {

    fun onSingUpClicked() {
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

        if (password.length < 7) {
            view.showPasswordError(R.string.error_password_character_limit)
            return
        }

        view.isLoading()

        service.startSignUpProcess(view, this)
    }

    override fun onSuccess() {
        view.onSignUpSuccess(R.string.success_sign_up)
    }

    override fun onFailure(errorMessage: String) {
        view.onSignUpFailure("Authentication Failed.\n$errorMessage")
    }

}