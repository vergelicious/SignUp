package com.example.signup3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val first = 1
        val min = 18
        val max = 60
        val seekBar : SeekBar = findViewById(R.id.seekBarAge)
        seekBar.setMax((max - min) / first)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, fromUser: Boolean) {
                val value = (min + (i * first))
                findViewById<TextView>(R.id.txtViewAge).setText("$value")
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        findViewById<Button>(R.id.btnNext).setOnClickListener{ toNextPage(
                findViewById<EditText>(R.id.txtFname).text.toString(),
                findViewById<EditText>(R.id.txtLname).text.toString(),
                findViewById<EditText>(R.id.txtEmail).text.toString(),
                findViewById<TextView>(R.id.txtViewAge).text.toString()
        ) }
    }
    private fun toNextPage(fname: String, lname: String, email: String, age: String) {
        val intent = Intent(this, NextPage::class.java)
        intent.putExtra("fName", fname)
        intent.putExtra("lName", lname)
        intent.putExtra("email", email)
        intent.putExtra("age", age)
        startActivity(intent)
    }
}