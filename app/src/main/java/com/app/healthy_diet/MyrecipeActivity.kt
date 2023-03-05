package com.app.healthy_diet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MyrecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itemsactivity)
        supportActionBar?.hide()
    }
}