package com.mithuroy.firebaseinoneapp.domain

import android.app.Activity
import android.content.Context
import com.google.firebase.auth.FirebaseAuthException
import com.mithuroy.firebaseinoneapp.view.LoginView

/**
 * Created by Mithu on July'04 2017
 */

class LoginService(val context: Context) {

    fun startLoginProcess(view: LoginView, callback: DomainCallback) {
        view.getFirebaseAuth().signInWithEmailAndPassword(view.getEmailAddress(), view.getPassword())
                .addOnCompleteListener(context as Activity, { task ->
                    if (task.isSuccessful) {
                        callback.onSuccess()
                    } else {
                        val e = task.exception as FirebaseAuthException
                        callback.onFailure(e.errorCode)
                    }
                })
    }
}