package com.mithuroy.firebaseinoneapp.view

import com.google.firebase.auth.FirebaseAuth

/**
 * Created by Mithu on July'10 2017
 */

interface ForgotPasswordView {

    fun getEmailAddress(): String
    fun getFirebaseAuth(): FirebaseAuth
    fun showEmailError(resourceId: Int)
    fun onResetPasswordSuccess(resourceId: Int)
    fun onResetPasswordFailure(errorMessage: Int)
}