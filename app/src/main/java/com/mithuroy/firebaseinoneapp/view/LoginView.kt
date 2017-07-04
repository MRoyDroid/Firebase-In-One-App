package com.mithuroy.firebaseinoneapp.view

import com.google.firebase.auth.FirebaseAuth


/**
 * Created by Mithu on July'04 2017
 */
interface LoginView {

    fun getEmailAddress(): String
    fun showEmailError(resourceId: Int)
    fun getPassword(): String
    fun showPasswordError(resourceId: Int)
    fun getFirebaseAuth(): FirebaseAuth
    fun onLoginSuccess(resourceId: Int)
    fun onLoginFailure(errorMessage: Int)
    fun isLoading()
}