package com.internshala.helloandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NewActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        title = "Login"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btLogin = findViewById(R.id.btnLogin)
        txtRegister = findViewById(R.id.txtRegister)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)

        btLogin.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        Toast.makeText(this@NewActivity, "Button Clicked", Toast.LENGTH_LONG).show()
    }
}