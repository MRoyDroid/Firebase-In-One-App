package com.mithuroy.firebaseinoneapp.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.mithuroy.firebaseinoneapp.R
import com.mithuroy.firebaseinoneapp.domain.LoginService
import com.mithuroy.firebaseinoneapp.peresenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    lateinit var auth: FirebaseAuth
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        presenter = LoginPresenter(this, LoginService(this))
    }

    fun onClickLoginButton(view: View) {
        presenter.onLoginClicked()
    }

    override fun getEmailAddress(): String {
        return et_login_email.text.toString()
    }

    override fun showEmailError(resourceId: Int) {
        et_login_email.error = getString(resourceId)
    }

    override fun getPassword(): String {
        return et_login_password.text.toString()
    }

    override fun showPasswordError(resourceId: Int) {
        et_login_password.error = getString(resourceId)
    }

    override fun getFirebaseAuth(): FirebaseAuth {
        return auth
    }

    override fun onLoginSuccess(resourceId: Int) {
        Toast.makeText(this, getString(resourceId), Toast.LENGTH_LONG).show()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onLoginFailure(errorMessage: Int) {
        Toast.makeText(this, getString(errorMessage), Toast.LENGTH_LONG).show()
        btn_login.visibility = View.VISIBLE
        pb_login.visibility = View.GONE
    }

    override fun isLoading() {
        btn_login.visibility = View.GONE
        pb_login.visibility = View.VISIBLE
    }
}
