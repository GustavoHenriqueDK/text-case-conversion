package com.example.textcaseconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testMethod()
    }

    private fun testMethod() {
        var counter = 1
        buttonGenerate.setOnClickListener {
            //Just for testing :p
            if (counter == 2) {
                textView.text = editTextText.text.toString().toUpperCase(Locale.ROOT)
                counter--
            } else {
                textView.text = editTextText.text.toString().toLowerCase(Locale.ROOT)
                counter++
            }
        }
    }
}