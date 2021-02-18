package com.chhaichivon.mvp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import com.chhaichivon.mvp.R
import com.chhaichivon.mvp.ui.post.PostActivity

class LoginActivity : AppCompatActivity() , View.OnClickListener{

    @BindView(R.id.et_username) lateinit var mUsernameEditText : EditText
    @BindView(R.id.et_password) lateinit var mPasswordEditText : EditText
    @BindView(R.id.btn_login) lateinit var mLoginButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this);
        mLoginButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v){
            mLoginButton -> login()
        }
    }

    fun login(){
        Log.d("mUsernameEditText : ", mUsernameEditText.text.toString())
        println()
        Log.d("mPasswordEditText : ", mPasswordEditText.text.toString())
        val intent = Intent(this, PostActivity::class.java)
        startActivity(intent)
        finish()
    }
}