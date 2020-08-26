package com.hungnd.androidday8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bai32.*

class Bai32Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai32)
        val intent = getIntent()
        val password = intent.getStringExtra("password")
        val phone = intent.getStringExtra("phone")
        val firstName = edt_First_Name.text.toString()
        val lastName = edt_Last_Name.text.toString()
        val email = edt_Email.text.toString()
        val date = edt_date.text.toString()
        btn_Continue.setOnClickListener {
            if (checkValidate()) {
                startActivity(Intent(this, Bai33Activity::class.java))
            }
        }


    }

    private fun checkValidate(): Boolean {
        if (TextUtils.isEmpty(edt_First_Name.text.toString())) {
            Toast.makeText(this, "Please enter your First name !!", Toast.LENGTH_SHORT).show()
            return false
        } else if (TextUtils.isEmpty(edt_Last_Name.text.toString())) {
            Toast.makeText(this, "Please enter your Last name !!", Toast.LENGTH_SHORT).show()
            return false
        } else if (TextUtils.isEmpty(edt_Email.text.toString())) {
            Toast.makeText(this, "Please enter your email !!", Toast.LENGTH_SHORT).show()
            return false
        } else if (TextUtils.isEmpty(edt_date.text.toString())) {
            Toast.makeText(this, "Please enter your date of birth!!", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }

    }
}