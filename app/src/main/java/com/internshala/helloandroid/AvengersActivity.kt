package com.internshala.helloandroid

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AvengersActivity : AppCompatActivity() {

    // Declaring variables.
    private var titleName: String? = "Avengers"
    private lateinit var etMessage: EditText
    private lateinit var btnSendMessage: Button
    private lateinit var btnLogout: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initializing sharedPreferences.
        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_avengers)

        // Fetching name of the avenger for the title from previous login screen.
        titleName = sharedPreferences.getString("title", "The Avengers")
        title = titleName

        // Finding views by id of elements.
        etMessage = findViewById(R.id.etMessage)
        btnSendMessage = findViewById(R.id.btnSendMessage)
        btnLogout = findViewById(R.id.btnLogout)


        // Button click events.
        btnSendMessage.setOnClickListener {

            val message = etMessage.text.toString()
            val intent = Intent(this@AvengersActivity, MessageActivity::class.java)

            if (message.isNotEmpty()) {
                intent.putExtra("Message", message)
                startActivity(intent)
                etMessage.text.clear()
            } else {
                Toast.makeText(
                    this@AvengersActivity,
                    "Please type a message first.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        // Logout Button click event.
        btnLogout.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            val intentLogout = Intent(this@AvengersActivity, LoginActivity::class.java)
            startActivity(intentLogout)
        }
    }
}