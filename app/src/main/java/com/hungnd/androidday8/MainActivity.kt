package com.hungnd.androidday8

import android.Manifest.permission.*
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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


        btn_Contact.setOnClickListener {
            val ContactIntent = Intent(Intent.ACTION_PICK);
            ContactIntent.setType(ContactsContract.Contacts.CONTENT_TYPE);
            if (ContextCompat.checkSelfPermission(
                    getApplicationContext(),
                    READ_CONTACTS
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                startActivityForResult(ContactIntent, 1)
                Toast.makeText(this, "Contact Ok", Toast.LENGTH_SHORT).show()
            } else {
                requestPermissions(
                    arrayOf<String>(READ_CONTACTS), 1

                )
            }

        }
        btn_Brower.setOnClickListener {
            val link = "https://www.facebook.com/"
            try {
                val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                startActivity(myIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    this, "you are so stupid", Toast.LENGTH_LONG
                ).show()
            }
        }
        btn_Call_Log.setOnClickListener {

            val showCallLog = Intent()
            showCallLog.action = Intent.ACTION_VIEW
            showCallLog.type = CallLog.Calls.CONTENT_TYPE

            if (ContextCompat.checkSelfPermission(
                    getApplicationContext(),
                    READ_CALL_LOG
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                startActivity(showCallLog)
                Toast.makeText(this, "Contact Ok", Toast.LENGTH_SHORT).show()
            } else {
                requestPermissions(
                    arrayOf<String>(READ_CALL_LOG), 1

                )
            }
        }
        btn_Gallery.setOnClickListener {
            val imageIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            imageIntent.type = "image/*"
            imageIntent.putExtra("crop", "true")
            imageIntent.putExtra("aspectX", 1)
            imageIntent.putExtra("aspectY", 1)
            imageIntent.putExtra("return-data", true)
            startActivityForResult(imageIntent, 1)

        }
        btn_Dialpad.setOnClickListener {
            val dialpadIntent = Intent(Intent.ACTION_DIAL)
            startActivity(dialpadIntent)
        }


    }


}