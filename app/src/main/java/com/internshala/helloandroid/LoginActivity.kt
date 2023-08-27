package com.internshala.helloandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var etMobileNumber: EditText
    private lateinit var etPassword: EditText
    private lateinit var btLogin: Button
    private lateinit var txtForgotPassword: TextView
    private lateinit var txtRegister: TextView

    private val validMobileNumber = "123"
    private val validPassword = arrayOf("tony", "steve", "bruce", "thor", "thanos")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title = "Login"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btLogin = findViewById(R.id.btnLogin)
        txtRegister = findViewById(R.id.txtRegister)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)


        btLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()

            val nameOfAvenger: String
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            if ((mobileNumber == validMobileNumber)) {

                when (password) {
                    validPassword[0] -> {
                        // If Tony Stark
                        nameOfAvenger = "Iron Man"
                        intent.putExtra("Name", nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[1] -> {
                        // If Steve Rogers
                        nameOfAvenger = "Captain America"
                        intent.putExtra("Name", nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[2] -> {
                        // If Hulk
                        nameOfAvenger = "Hulk"
                        intent.putExtra("Name", nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[3] -> {
                        // If Thor
                        nameOfAvenger = "Thor"
                        intent.putExtra("Name", nameOfAvenger)
                        startActivity(intent)
                    }

                    else -> {
                        // Any other Avengers
                        nameOfAvenger = "Other Avengers"
                        intent.putExtra("Name", nameOfAvenger)
                        startActivity(intent)
                    }
                }
            } else {
                Toast.makeText(
                    this@LoginActivity, "Incorrect Credentials!", Toast.LENGTH_LONG
                ).show()
            }
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

}