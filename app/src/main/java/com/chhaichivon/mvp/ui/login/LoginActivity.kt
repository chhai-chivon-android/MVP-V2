package com.chhaichivon.mvp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import com.chhaichivon.mvp.R

class LoginActivity : AppCompatActivity() {

    @BindView(R.id.et_username) lateinit var mUsernameEditText : EditText
    @BindView(R.id.et_password) lateinit var mPasswordEditText : EditText
    @BindView(R.id.btn_login) lateinit var mLoginButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}