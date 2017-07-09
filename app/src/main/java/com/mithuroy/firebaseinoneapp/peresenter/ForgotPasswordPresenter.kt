package com.mithuroy.firebaseinoneapp.peresenter

import com.mithuroy.firebaseinoneapp.R
import com.mithuroy.firebaseinoneapp.domain.DomainCallback
import com.mithuroy.firebaseinoneapp.domain.ForgotPasswordService
import com.mithuroy.firebaseinoneapp.view.ForgotPasswordView

/**
 * Created by Mithu on July'10 2017
 */

class ForgotPasswordPresenter(val view: ForgotPasswordView, val service: ForgotPasswordService) : DomainCallback {

    fun onResetPasswordClick() {

        val emailAddress = view.getEmailAddress()

        if (emailAddress.isEmpty()) {
            view.showEmailError(R.string.error_email)
            return
        }

        service.resetPassword(view, this)
    }

    override fun onSuccess() {
        view.onResetPasswordSuccess(R.string.success_reset_password)
    }

    override fun onFailure(errorCode: String) {
        view.onResetPasswordFailure(R.string.error_general)
    }

}