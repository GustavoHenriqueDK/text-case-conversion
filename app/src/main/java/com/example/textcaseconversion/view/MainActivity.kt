package com.example.textcaseconversion.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.textcaseconversion.R
import com.example.textcaseconversion.controller.ConvertCase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideStatusBarAndSupportBar()

        val convertCase = ConvertCase()
        Log.e("testing this ", convertCase.toAlternativeCase("Gustavo"))

        changeTextInRealTime()
        getSelectedItemInSpinner()
    }

    private fun getSelectedItemInSpinner(): String {
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (spinner.selectedItem.toString() == "Letras maiúsculas") {
                    editTextTextOutput.setText(editTextText.text.toString().toUpperCase())
                }
                if (spinner.selectedItem.toString() == "Letras minúsculas") {
                    editTextTextOutput.setText(editTextText.text.toString().toLowerCase())
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        return spinner.selectedItem.toString()
    }

    private fun hideStatusBarAndSupportBar() {
        supportActionBar!!.hide()

    }

    private fun changeTextInRealTime() {
        editTextText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(output: Editable) {
                if (spinner.selectedItem.toString() == "Letras maiúsculas") {
                    editTextTextOutput.setText(output.toString().toUpperCase())
                }
                if (spinner.selectedItem.toString() == "Letras minúsculas") {
                    editTextTextOutput.setText(output.toString().toLowerCase())
                }
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