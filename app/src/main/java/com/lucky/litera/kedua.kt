package com.lucky.litera

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class kedua : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kedua)

        // Ambil referensi ImageView
        val kiridua = findViewById<ImageView>(R.id.kiridua)
        val kanandua = findViewById<ImageView>(R.id.kanandua)

        // Pindah kembali ke MainActivity
        kiridua.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        kanandua.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
