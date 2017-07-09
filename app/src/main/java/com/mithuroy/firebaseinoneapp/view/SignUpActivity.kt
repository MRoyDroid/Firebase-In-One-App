package com.mithuroy.firebaseinoneapp.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.mithuroy.firebaseinoneapp.R
import com.mithuroy.firebaseinoneapp.domain.SignUpService
import com.mithuroy.firebaseinoneapp.peresenter.SignUpPresenter
import kotlinx.android.synthetic.main.activity_sign_up.*

/**
 * Created by Mithu on June'26 2017
 */

class SignUpActivity : AppCompatActivity(), SignUpView {

    lateinit var auth: FirebaseAuth
    lateinit var presenter: SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()
        presenter = SignUpPresenter(this, SignUpService(this))

        initListeners()
    }

    private fun initListeners() {
        btn_sign_up.setOnClickListener { presenter.onSingUpClicked() }
        txt_sign_up_login.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }
    }

    override fun getEmailAddress(): String {
        return et_sign_up_email.text.toString()
    }

    override fun showEmailError(resourceId: Int) {
        et_sign_up_email.error = getString(resourceId)
    }

    override fun getPassword(): String {
        return et_sign_up_password.text.toString()
    }

    override fun showPasswordError(resourceId: Int) {
        et_sign_up_password.error = getString(resourceId)
    }

    override fun getFirebaseAuth(): FirebaseAuth {
        return auth
    }

    override fun onSignUpSuccess(resourceId: Int) {
        Toast.makeText(this, getString(resourceId), Toast.LENGTH_LONG).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onSignUpFailure(errorMessage: Int) {
        Toast.makeText(this, getString(errorMessage), Toast.LENGTH_LONG).show()
        btn_sign_up.visibility = View.VISIBLE
        pb_sign_up.visibility = View.GONE
    }

    override fun isLoading() {
        btn_sign_up.visibility = View.GONE
        pb_sign_up.visibility = View.VISIBLE
    }
}
