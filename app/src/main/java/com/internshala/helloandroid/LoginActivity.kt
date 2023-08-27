package com.internshala.helloandroid

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    // Declaring variables.
    private lateinit var etMobileNumber: EditText
    private lateinit var etPassword: EditText
    private lateinit var btLogin: Button
    private lateinit var txtForgotPassword: TextView
    private lateinit var txtRegister: TextView
    private val validMobileNumber = "123"
    private val validPassword = arrayOf("tony", "steve", "bruce", "thor", "thanos")

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initializing sharedPreferences.
        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        setContentView(R.layout.activity_login)

        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Login"

        // Finding views by ids.
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btLogin = findViewById(R.id.btnLogin)
        txtRegister = findViewById(R.id.txtRegister)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)


        // Button and other click events.
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
                        savePreference(nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[1] -> {
                        // If Steve Rogers
                        nameOfAvenger = "Captain America"
                        savePreference(nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[2] -> {
                        // If Hulk
                        nameOfAvenger = "Hulk"
                        savePreference(nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[3] -> {
                        // If Thor
                        nameOfAvenger = "Thor"
                        savePreference(nameOfAvenger)
                        startActivity(intent)
                    }

                    else -> {
                        // Any other Avengers
                        nameOfAvenger = "Other Avengers"
                        savePreference(nameOfAvenger)
                        startActivity(intent)
                    }
                }
            } else {
                Toast.makeText(
                    this@LoginActivity, "Incorrect Credentials!", Toast.LENGTH_LONG
                ).show()
            }
        }

        // When clicked on Forgot Password text this event will trigger.
        txtForgotPassword.setOnClickListener {
            val intentForgotPassword = Intent(this@LoginActivity, ForgotPassword::class.java)
            startActivity(intentForgotPassword)
        }

        // When clicked on Register text this event will trigger.
        txtRegister.setOnClickListener {
            val intentRegistration = Intent(this@LoginActivity, RegistrationActivity::class.java)
            startActivity(intentRegistration)
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    // SharedPreference to set the initial login state of a user and also passing the title text.
    private fun savePreference(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("title", title).apply()
    }

}