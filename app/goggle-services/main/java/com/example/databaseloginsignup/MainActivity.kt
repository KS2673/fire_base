package com.example.databaseloginsignup

import android.R
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


private infix fun <R1> (() -> R1).private(function: (Cursor, String, String) -> Boolean): View.OnClickListener? {
return null
}

class MainActivity : AppCompatActivity() {
    private lateinit var loginbtn:Button
    private lateinit var email:EditText
    private lateinit var pswd:EditText
    private lateinit var loginfcbk:Button
    private lateinit var frgtpswrd:TextView
    private lateinit var signup:Button
   private lateinit var dbHelper: DBHelper

    /*   var email: EditText? = null
           var password: EditText? = null
           var btnSubmit: Button? = null
           var createAcc: TextView? = null
           var dbHelper: DBHelper? = null*/
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(com.example.databaseloginsignup.R.layout.activity_main)

        loginbtn.setOnClickListener(object : OnClickListener
        {
            fun onclick(View: View?)
            {
                var emailCheck = email.getText().toString()
                var passCheck = pswd.getText().toString()
                val cursor:Cursor = dbHelper.getData()

                if (cursor.getCount() === 0)
                {
                    Toast.makeText(this@MainActivity, "No person Exists", Toast.LENGTH_LONG).show()
                }
                if (loginbtn == cursor){
                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    intent.putExtra("email", emailCheck)
                    email.setText("")
                    pswd.setText("")
                    startActivity(intent)
                } else {
                    val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
                    builder.setCancelable(true)
                    builder.setTitle("Wrong Credential")
                    builder.setMessage("Wrong Credential")
                    builder.show()
                }
                dbHelper.close()
            }

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            override fun onClick(v: View?) {
                TODO("Not yet implemented")
            }


        }

        )
        // signup=findViewById(R.id.)
        signup.setOnClickListener({
            var value = object : OnClickListener {
                fun Click(view: View?) {
                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    startActivity(intent)

                }

                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                override fun onClick(v: View?) {
                    TODO("Not yet implemented")
                }
            }
        })
    }
}

              /*  fun loginCheck(cursor: Cursor, emailCheck: String?, passCheck: String?): Boolean {
                    while (cursor.moveToNext()) {
                        if (cursor.getString(0).equals(emailCheck)) {
                            return if (cursor.getString(2).equals(passCheck)) {
                                true
                            } else false
                        }
                    }
                    return false


                }

                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                override fun onClick(v: View?) {
                    TODO("Not yet implemented")
                }
            }


    }

    private fun(cursor: Cursor, emailCheck: String, passCheck: String): Boolean {
            while (cursor.moveToNext()) {
                if (cursor.getString(0).equals(emailCheck)) {
                    return if (cursor.getString(2).equals(passCheck)) {
                        true
                    } else false
                }
            }
            return false

        })

    }
}





