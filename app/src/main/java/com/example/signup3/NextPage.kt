package com.example.signup3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Switch
import androidx.core.view.isVisible

class NextPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_page)

        val picker: DatePicker = findViewById<DatePicker>(R.id.calendarView)
        var birthday = "${picker.month}/${picker.dayOfMonth}/${picker.year}"
        picker.init(2002, 1, 1, object: DatePicker.OnDateChangedListener{
            override fun onDateChanged(
                view: DatePicker?,
                year: Int,
                monthOfYear: Int,
                dayOfMonth: Int
            ) {
                birthday = "${picker.month}/${picker.dayOfMonth}/${picker.year}"
            }
        })

        findViewById<Button>(R.id.btnSignUp).setOnClickListener{ toSignUp(

            intent.getStringExtra("firstName").toString(),
            intent.getStringExtra("lastName").toString(),
            intent.getStringExtra("email").toString(),
            intent.getStringExtra("age").toString(),
            findViewById<EditText>(R.id.txtPhoneNo).text.toString(),
            birthday
        )}

        findViewById<Switch>(R.id.switchPhoneNo).setOnClickListener {showPhone()}
    }

    private fun showPhone() {
        val switch: Switch = findViewById<Switch>(R.id.switchPhoneNo) as Switch
        if (switch.isChecked() == true ) {
            findViewById<EditText>(R.id.txtPhoneNo).isVisible = true
        } else if (switch.isChecked() == false ) {
            findViewById<EditText>(R.id.txtPhoneNo).isVisible = false
        }
    }

    private fun toSignUp(firstName: String, lastName: String, email: String, age: String, phoneNumber: String, birthday: String) {
        val intent = Intent(this, SignUp::class.java)
        intent.putExtra("firstName", firstName)
        intent.putExtra("lastName", lastName)
        intent.putExtra("email", email)
        intent.putExtra("age", age)
        intent.putExtra("birthday", birthday)

        val switch: Switch = findViewById<Switch>(R.id.switchPhoneNo) as Switch
        if (switch.isChecked() == true) {
            intent.putExtra("phoneNumber", phoneNumber)
        } else if (switch.isChecked() == false ) {
            intent.putExtra("phoneNumber", "No phone number.")
        }
        startActivity(intent)
    }
}