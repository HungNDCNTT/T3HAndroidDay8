package com.hungnd.androidday8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bai3.*

class Bai3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai3)
        val phoneNumber = edt_Phone_Number.text.toString()
        val password = edt_Password.text.toString()
        btn_Sign_Up.setOnClickListener {

            if (checkValidate()) {
                val intent = Intent(this, Bai32Activity::class.java)
                intent.putExtra("phone", phoneNumber)
                intent.putExtra("password", password)
                startActivity(intent)

            } else {
                Toast.makeText(this, "You are so good but I'm so sorry", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun checkValidate(): Boolean {
        if (TextUtils.isEmpty(edt_Phone_Number.text.toString())) {
            Toast.makeText(this, "Please enter your phone number !!", Toast.LENGTH_SHORT).show()
            return false
        } else if (TextUtils.isEmpty(edt_Password.text.toString())) {
            Toast.makeText(this, "Please enter your password !!", Toast.LENGTH_SHORT).show()
            return false
        } else if (TextUtils.isEmpty(edt_Confirm_Pass.text.toString())) {
            Toast.makeText(this, "Please confirm your password !!", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }


    }
}