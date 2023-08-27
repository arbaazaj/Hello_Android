package com.internshala.helloandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NewActivity : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView

    val validMobileNumber = "1234567890"
    val validPassword = "thanos"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        title = "Login"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btLogin = findViewById(R.id.btnLogin)
        txtRegister = findViewById(R.id.txtRegister)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)


        btLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            if ((mobileNumber == validMobileNumber) && (password == validPassword)) {
                val intent = Intent(this@NewActivity, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@NewActivity, "Incorrect Credentials!", Toast.LENGTH_LONG
                ).show()
            }
        }

    }

}