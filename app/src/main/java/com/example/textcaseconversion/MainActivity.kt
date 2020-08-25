package com.example.textcaseconversion

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //TO-DO: o texto não pode ser grande a ponto do scroll view ocupar toda a tela!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideStatusBarAndSupportBar()

        changeTextInRealTime()
    }

    private fun hideStatusBarAndSupportBar() {
        supportActionBar!!.hide()

    }

    private fun changeTextInRealTime() {
        editTextText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(output: Editable) {
                editTextTextOutput.setText(output.toString())
            }

            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }
        })
    }
}