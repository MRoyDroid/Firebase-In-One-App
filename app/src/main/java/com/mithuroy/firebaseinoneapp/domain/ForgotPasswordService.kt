package com.mithuroy.firebaseinoneapp.domain

import android.content.Context
import com.mithuroy.firebaseinoneapp.R
import com.mithuroy.firebaseinoneapp.view.ForgotPasswordView

/**
 * Created by Mithu on July'10 2017
 */

class ForgotPasswordService(val context: Context) {

    fun resetPassword(view: ForgotPasswordView, callback: DomainCallback) {
        view.getFirebaseAuth().sendPasswordResetEmail(view.getEmailAddress())
                .addOnCompleteListener({ task ->
                    if (task.isSuccessful) {
                        callback.onSuccess()

                    } else {
                        view.onResetPasswordFailure(R.string.error_general)
                    }
                })
    }
}