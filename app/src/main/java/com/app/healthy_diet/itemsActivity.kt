package com.app.healthy_diet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class itemsActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itemsactivity)
        supportActionBar?.hide()
    }
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment with the ProductGrid theme
//        val view = inflater.inflate(R.layout.itemsactivity, container, false)
//
//        // Set up the toolbar.
//        val activity = null
//        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
//
//        return view;
//    }
}