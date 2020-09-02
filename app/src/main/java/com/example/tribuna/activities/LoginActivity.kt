package com.example.tribuna.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tribuna.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private fun init() {
        btn_login.setOnClickListener {

        }
    }

    fun setUserAuth(){

    }
}