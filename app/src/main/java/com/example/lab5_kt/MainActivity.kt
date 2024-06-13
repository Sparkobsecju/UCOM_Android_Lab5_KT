package com.example.lab5_kt

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "LAB5_ANIM"
    }

    private lateinit var button1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        button1 = findViewById(R.id.button1)
        button1.setOnClickListener { executeAnimation1() }
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val imageView: ImageView = findViewById(R.id.imageView)
            val imageView2: ImageView = findViewById(R.id.imageView2)
            imageView.visibility = View.VISIBLE
            imageView2.visibility = View.VISIBLE
        }
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            executeAnimation2()
        }
        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener {
            executeAnimation3()
        }
    }

    private fun executeAnimation3() {
        val animation3 = AnimationUtils.loadAnimation(this, R.anim.animation3)
        val imageView: ImageView = findViewById(R.id.imageView)
        imageView.startAnimation(animation3)
    }

    private fun executeAnimation2() {
        val animation2 = AnimationUtils.loadAnimation(this, R.anim.animation2)
        val imageView: ImageView = findViewById(R.id.imageView)
        imageView.startAnimation(animation2)

    }


    private fun executeAnimation1() {
        val animation1 = AnimationUtils.loadAnimation(this, R.anim.animation1)
        val imageView: ImageView = findViewById(R.id.imageView)
        val imageView2: ImageView = findViewById(R.id.imageView2)
        Log.v(TAG, "before start animation")
        imageView.startAnimation(animation1)
        imageView2.startAnimation(animation1)
        Log.v(TAG, "after start animation")
        imageView.visibility = View.INVISIBLE
        imageView2.visibility = View.INVISIBLE
        Log.v(TAG, "after set visibility")
        button1.isEnabled = false
        Thread {
            Thread.sleep(8000)
            runOnUiThread { button1.isEnabled = true }
        }.start()

    }
}