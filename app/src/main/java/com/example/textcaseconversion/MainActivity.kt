package com.example.textcaseconversion

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import android.widget.RadioButton
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
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    private fun changeTextInRealTime() {
        editTextText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                val value = s.toString()
                textView.text = value
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

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.radioButtonLowerCase ->
                    if (checked) {
                        textView.text = textView.text.toString().toLowerCase()
                    }
                R.id.radioButtonUpperCase ->
                    if (checked) {
                        textView.text = textView.text.toString().toUpperCase()
                    }
                R.id.radioButtonAlternativeCase ->
                    if (checked) {
                        //TO-DO: Alternative case!
                    }
                R.id.radioButtonAlternativeCase2 ->
                    if (checked) {
                        //TO-DO: Alternative case 2!
                    }
                R.id.radioButtonFormalText ->
                    if (checked) {
                        //TO-DO: Formal text!
                    }
            }
        }
    }
}