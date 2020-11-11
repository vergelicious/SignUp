package com.example.signup3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        findViewById<TextView>(R.id.textViewFirstName).setText("${( intent.getStringExtra("fName"))}")
        findViewById<TextView>(R.id.textViewLastName).setText("${( intent.getStringExtra("lName"))}")
        findViewById<TextView>(R.id.textViewEmail).setText("${( intent.getStringExtra("email"))}")
        findViewById<TextView>(R.id.textViewAge).setText("${( intent.getStringExtra("age"))}")
        findViewById<TextView>(R.id.textViewBirthday).setText("${( intent.getStringExtra("birthday") )}")
        findViewById<TextView>(R.id.textViewPhoneNumber).setText("${ (intent.getStringExtra("phoneNo"))}")
    }
}