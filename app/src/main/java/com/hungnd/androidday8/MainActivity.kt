package com.hungnd.androidday8

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.CAMERA
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_Call.setOnClickListener {
            var numberPhone = edt_Phone_Number.text.toString().trim()
            Log.e("hungnd", "$numberPhone")
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:0919700645")
            if (ContextCompat.checkSelfPermission(
                    getApplicationContext(),
                    CALL_PHONE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                startActivity(intent)
                Toast.makeText(this, "Call Ok", Toast.LENGTH_SHORT).show()
            } else {
                requestPermissions(
                    arrayOf<String>(CALL_PHONE), 1

                )
            }


        }
        btn_Camera.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (ContextCompat.checkSelfPermission(
                    getApplicationContext(),
                    CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                startActivity(cameraIntent)
                Toast.makeText(this, "Camera Ok", Toast.LENGTH_SHORT).show()
            } else {
                requestPermissions(
                    arrayOf<String>(CAMERA), 1

                )
            }
        }


        btn_Contact.setOnClickListener {  }
//        btn_Brower.setOnClickListener { this }
//        btn_Call_Log.setOnClickListener { this }
//        btn_Gallery.setOnClickListener { this }
//        btn_Dialpad.setOnClickListener { this }


    }


}