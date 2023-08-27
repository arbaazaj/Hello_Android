package com.internshala.helloandroid

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    // Declaring variables.
    private lateinit var etName: EditText
    private lateinit var etMobileNumber: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Finding views by id from the resources layout file.
        etName = findViewById(R.id.etName)
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)


        // Button click event
        btnRegister.setOnClickListener{

        }

    }
}