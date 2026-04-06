package com.example.discreetdispatch

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rootView = findViewById<View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set click listeners for all buttons
        findViewById<Button>(R.id.btn_police).setOnClickListener(this)
        findViewById<Button>(R.id.btn_fire).setOnClickListener(this)
        findViewById<Button>(R.id.btn_ems).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_police -> {
                startActivity(Intent(this, police::class.java))
            }
            R.id.btn_fire -> {
                startActivity(Intent(this, Fire::class.java))
            }
            R.id.btn_ems -> {
                startActivity(Intent(this, EMS::class.java))
            }
        }
    }
}

