package com.mithuroy.firebaseinoneapp.domain

/**
 * Created by Mithu on June'26 2017
 */

interface SignUpCallBack {
    fun onSuccess()
    fun onFailure(errorMessage: String)
}