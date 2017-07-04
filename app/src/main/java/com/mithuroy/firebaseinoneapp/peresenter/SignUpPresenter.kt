package com.mithuroy.firebaseinoneapp.peresenter

import com.mithuroy.firebaseinoneapp.R
import com.mithuroy.firebaseinoneapp.domain.SignUpCallBack
import com.mithuroy.firebaseinoneapp.domain.SignUpService
import com.mithuroy.firebaseinoneapp.view.SignUpView

/**
 * Created by Mithu on June'26 2017
 */

class SignUpPresenter(val view: SignUpView, val service: SignUpService) : SignUpCallBack {

    companion object {
        val PASSWORD_MAX_LIMIT = 8
    }

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

        if (password.length < PASSWORD_MAX_LIMIT - 1) {
            view.showPasswordError(R.string.error_password_character_limit)
            return
        }

        view.isLoading()

        service.startSignUpProcess(view, this)
    }

    override fun onSuccess() {
        view.onSignUpSuccess(R.string.success_sign_up)
    }

    override fun onFailure(errorCode: String) {
        if (errorCode == "ERROR_EMAIL_ALREADY_IN_USE")
            view.onSignUpFailure(R.string.error_email_already_in_use)
        else
            view.onSignUpFailure(R.string.error_general)
    }

}