package com.mithuroy.firebaseinoneapp.domain

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.firebase.auth.FirebaseAuthException
import com.mithuroy.firebaseinoneapp.view.SignUpView

/**
 * Created by Mithu on June'26 2017
 */

class SignUpService(val context: Context) {

    fun startSignUpProcess(view: SignUpView, callBack: DomainCallback) {
        view.getFirebaseAuth().createUserWithEmailAndPassword(view.getEmailAddress(), view.getPassword())
                .addOnCompleteListener(context as Activity, { task ->
                    if (task.isSuccessful) {
                        callBack.onSuccess()
                    } else {
                        Log.i("Exception", task.exception.toString())
                        val e = task.exception as FirebaseAuthException
                        callBack.onFailure(e.errorCode)
                    }
                })
    }
}
