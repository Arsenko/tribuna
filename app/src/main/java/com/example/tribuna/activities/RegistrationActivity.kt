package com.example.tribuna.activities

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.tribuna.R
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        init()
    }

    private fun init() {
        edt_registration_password.transformationMethod=PasswordTransformationMethod.getInstance()
        edt_registration_repeat_password.transformationMethod=PasswordTransformationMethod.getInstance()

        btn_register.setOnClickListener {
            val toIdeaList:Intent=Intent(this,MainActivity::class.java)
            startActivity(toIdeaList)
        }
    }
}