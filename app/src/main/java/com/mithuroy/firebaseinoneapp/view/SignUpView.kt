package com.mithuroy.firebaseinoneapp.view

import com.google.firebase.auth.FirebaseAuth

/**
 * Created by Mithu on June'26 2017
 */

interface SignUpView {
    fun getEmailAddress(): String
    fun showEmailError(resourceId: Int)
    fun getPassword(): String
    fun showPasswordError(resourceId: Int)
    fun getFirebaseAuth(): FirebaseAuth
    fun onSignUpSuccess(resourceId: Int)
    fun onSignUpFailure(errorMessage: Int)
    fun isLoading()
}