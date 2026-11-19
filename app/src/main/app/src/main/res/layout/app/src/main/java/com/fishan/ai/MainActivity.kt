package com.fishan.ai

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences("fishan_prefs", Context.MODE_PRIVATE)
        val etApiKey = findViewById<EditText>(R.id.etApiKey)
        val btnSaveKey = findViewById<Button>(R.id.btnSaveKey)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        val savedKey = prefs.getString("api_key", "")
        if (!savedKey.isNullOrEmpty()) {
            etApiKey.setText(savedKey)
            tvStatus.text = "Status: API Key Loaded"
        }

        btnSaveKey.setOnClickListener {
            val keyInput = etApiKey.text.toString().trim()
            if (keyInput.isEmpty()) {
                tvStatus.text = "Status: Please enter a valid API key"
            } else {
                prefs.edit().putString("api_key", keyInput).apply()
                tvStatus.text = "Status: API Key Saved"
            }
        }
    }
}
