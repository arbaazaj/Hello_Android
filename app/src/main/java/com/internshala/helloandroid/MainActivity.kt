package com.internshala.helloandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var titleName: String? = "Avengers"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scrollview_example)

        if (intent != null) {
            intent.getStringExtra("Name")
        }

        title = titleName
    }
}