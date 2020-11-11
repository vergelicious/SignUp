package com.example.signup3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible

class NextPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_page)

        var picker: DatePicker = findViewById(R.id.calendarView)
        var birthday = "${picker.month}/${picker.dayOfMonth}/${picker.year}"
        picker.init(2002, 1, 1, object: DatePicker.OnDateChangedListener{
            override fun onDateChanged(
                view: DatePicker,
                year: Int,
                monthOfYear: Int,
                dayOfMonth: Int
            ) {
                birthday = "${picker.month + 1}/${picker.dayOfMonth}/${picker.year}"
            }
        })

        findViewById<Button>(R.id.btnSignUp).setOnClickListener{ toSignUp(

            intent.getStringExtra("fName").toString(),
            intent.getStringExtra("lName").toString(),
            intent.getStringExtra("email").toString(),
            intent.getStringExtra("age").toString(),
            findViewById<EditText>(R.id.txtPhoneNo).text.toString(),
            birthday
        )}

        findViewById<Switch>(R.id.switchPhoneNo).setOnClickListener { displayStatus() }
    }


    private fun displayStatus() {
        val switch: Switch = findViewById(R.id.switchPhoneNo)
        if (switch.isChecked() == true ) {
            findViewById<EditText>(R.id.txtPhoneNo).isVisible = true
        } else if (switch.isChecked() == false ) {
            findViewById<EditText>(R.id.txtPhoneNo).isVisible = false
        }
    }

    private fun toSignUp(firstName: String, lastName: String, email: String, age: String, phoneNumber: String, birthday: String) {
        val intent = Intent(this, SignUp::class.java)
        intent.putExtra("fName", firstName)
        intent.putExtra("lName", lastName)
        intent.putExtra("email", email)
        intent.putExtra("age", age)
        intent.putExtra("birthday", birthday)





        val switch: Switch = findViewById(R.id.switchPhoneNo)
        if (switch.isChecked() == true) {
            intent.putExtra("phoneNo", phoneNumber)
        } else if (switch.isChecked() == false ) {
            intent.putExtra("phoneNo", "No phone number.")
        }
        startActivity(intent)
    }
}