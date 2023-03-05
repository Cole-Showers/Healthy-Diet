package com.app.healthy_diet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val loginButton= findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {
            val click=Intent(this,LogIn::class.java )
            startActivity(click)

        }
        val signUpTxt = findViewById<TextView>(R.id.signUpTxt)


        signUpTxt.setOnClickListener {

            val switchActivity = Intent(this, SignUp::class.java)
            startActivity(switchActivity)
        }


    }



}