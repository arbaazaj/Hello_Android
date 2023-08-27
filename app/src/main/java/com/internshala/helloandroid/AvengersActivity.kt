package com.internshala.helloandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AvengersActivity : AppCompatActivity() {

    private var titleName: String? = "Avengers"
    private lateinit var etMessage: EditText
    private lateinit var btnSendMessage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)
        if (intent != null) {
            intent.getStringExtra("Name")
        }
        title = titleName

        etMessage = findViewById(R.id.etMessage)
        btnSendMessage = findViewById(R.id.btnSendMessage)

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


    }
}