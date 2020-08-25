package com.example.textcaseconversion

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //todo: o texto não pode ser grande a ponto do scroll view ocupar toda a tela!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideStatusBarAndSupportBar()

        testMethod()
    }

    private fun hideStatusBarAndSupportBar() {
        supportActionBar!!.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    private fun testMethod() {
        button.setOnClickListener {
            textView.text = editTextText.text.toString()
        }
    }
}