package com.example.databaseloginsignup

import android.R
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalPage : AppCompatActivity() {
    var text: TextView? = null
    override fun onBackPressed() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_page2)
        text = findViewById<TextView>(R.id.changeText)
        val intent = intent
        val s2 = intent.getStringExtra("userName")
        text.setText(s2)
    }
}