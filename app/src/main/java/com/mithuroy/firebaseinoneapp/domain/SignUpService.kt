package com.mithuroy.firebaseinoneapp.domain

import android.app.Activity
import android.content.Context
import com.mithuroy.firebaseinoneapp.view.SignUpView


/**
 * Created by Mithu on June'26 2017
 */
class SignUpService(val context: Context) {

    fun startSignUpProcess(view: SignUpView, callBack: SignUpCallBack) {
        view.getFirebaseAuth().createUserWithEmailAndPassword(view.getEmailAddress(), view.getPassword())
                .addOnCompleteListener(context as Activity, { task ->
                    if (task.isSuccessful) {
                        callBack.onSuccess()
                    } else {
                        callBack.onFailure(task.exception.toString())
                    }
                })
    }
}
