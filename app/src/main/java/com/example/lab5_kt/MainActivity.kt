package com.example.lab5_kt

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener { executeAnimation1() }
    }

    private fun executeAnimation1() {
        val animation1 = AnimationUtils.loadAnimation(this, R.anim.animation1)
        val imageView: ImageView = findViewById(R.id.imageView)
        imageView.startAnimation(animation1)
        val imageView2: ImageView = findViewById(R.id.imageView2)
        imageView2.startAnimation(animation1)
        imageView.visibility = View.INVISIBLE
        imageView2.visibility = View.INVISIBLE

    }
}