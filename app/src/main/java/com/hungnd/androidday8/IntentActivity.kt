package com.hungnd.androidday8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent.*

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        btn_Bai1.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
        btn_Bai2.setOnClickListener { startActivity(Intent(this, Bai2Activity::class.java)) }
        btn_Bai3.setOnClickListener { startActivity(Intent(this, Bai3Activity::class.java)) }
    }
}