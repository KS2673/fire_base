package com.example.databaseloginsignup

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.databaseloginsignup.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class Login : AppCompatActivity() {
    private lateinit var userName: EditText
    private lateinit var password: EditText
    private lateinit var btnSubmit: Button
    private lateinit var createAcc: TextView
    private lateinit var firebaseDatabase:FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.Login_activity)

        userName = findViewById(R.id.text_email)
        password = findViewById(R.id.text_pass)
        btnSubmit = findViewById(R.id.btnSubmit_login)
        createAcc = findViewById(R.id.createAcc)

        btnSubmit.setOnClickListener(View.OnClickListener {
            val userName1 = userName.text.toString()
            val passCheck = password.text.toString().toLong()

            firebaseDatabase = FirebaseDatabase.getInstance()
            reference = firebaseDatabase.getReference("User")
            val query: Query = reference.orderByChild("userName").equalTo(userName1)

            query.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val pass: Long? = snapshot.child(userName1).child("pass").getValue(Long::class.java)
                        if (pass == passCheck) {
                            val intent = Intent(this@Login, FinalPage::class.java)
                            intent.putExtra("userName", userName1)
                            startActivity(intent)
                            Toast.makeText(this@Login, "Right Pass", Toast.LENGTH_SHORT).show()
                        } else {
                            val builder = AlertDialog.Builder(this@Login)
                            builder.setCancelable(true)
                            builder.setTitle("Wrong Credential")
                            builder.setMessage("Wrong Credential")
                            builder.show()
                        }
                    } else {
                        Toast.makeText(this@Login, "No data exists", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
        })

        createAcc.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Login, SignUp::class.java)
            startActivity(intent)
        })
    }
}
