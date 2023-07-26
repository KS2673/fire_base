package com.example.databaseloginsignup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.databaseloginsignup.R.id.tool_main

class MainActivity : AppCompatActivity() {
    private lateinit var login: Button
    private lateinit var Reg: Button
    private lateinit var toolbar: Toolbar
    private lateinit var dbHelper: DBHelper

    override fun onBackPressed() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DBHelper(this)
        login = findViewById(R.id.btnLogin)
        toolbar = findViewById(tool_main)

        login.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)
        })

        Reg = findViewById(R.id.btnSignUp)
        Reg.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, SignUp::class.java)
            startActivity(intent)
        })
    }
}
