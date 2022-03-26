package com.example.test

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        supportActionBar?.hide()

        val score = findViewById<TextView>(R.id.score)
        val button = findViewById<Button>(R.id.newGame2)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        score.setText(message)

        button.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}