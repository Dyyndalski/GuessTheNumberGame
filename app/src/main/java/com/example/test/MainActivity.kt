package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        var score = 0;
        var shotCounter = 0;

        val but = findViewById<Button>(R.id.shot)
        val output = findViewById<TextView>(R.id.out)
        val input = findViewById<EditText>(R.id.input)

        val rand = Random()
        var result: Int = rand.nextInt(21)

        val reset = findViewById<Button>(R.id.reset)

        val scoreOutput = findViewById<TextView>(R.id.score)

        reset.setOnClickListener() {
            score = 0;
            shotCounter = 0;
            scoreOutput.setText(score.toString())
            output.setText("Podaj liczbe!")
        }

        but.setOnClickListener() {

            if (input.getText().toString().trim().length != 0) {
                val text = Integer.parseInt(input.getText().toString());

                if (text >= 0 && text <= 20) {
                    shotCounter++
                    if (shotCounter > 10) {
                        input.setText("");
                        val intent = Intent(this, NewActivity::class.java).apply {
                            putExtra(EXTRA_MESSAGE, score.toString())
                        }
                        startActivity(intent)
                    } else {
                        input.setText("");
                        if (text < result)
                            output.setText("Podaj większą liczbę!")
                        else
                            output.setText("Podaj mniejszą liczbę!")

                        if (text == result) {
                            output.setText("Brawo! Udało Ci się!")

                            if (shotCounter == 1) {
                                score += 5
                            } else if (shotCounter >= 2 && shotCounter <= 4) {
                                score += 3
                            } else if (shotCounter == 6 || shotCounter == 5) {
                                score += 2
                            } else if (shotCounter >= 7 && shotCounter <= 10) {
                                score += 1
                            }
                            scoreOutput.setText(score.toString())
                            shotCounter = 0;
                            result = rand.nextInt(21)

                        }
                    }
                } else {
                    input.setText("");
                    output.setText("Podałeś liczbę spoza zakresu! :(");
                }
            }
        }

    }
}
