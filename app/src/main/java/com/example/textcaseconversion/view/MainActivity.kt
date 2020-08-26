package com.example.textcaseconversion.view

import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.textcaseconversion.R
import com.example.textcaseconversion.controller.ConvertCase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val mutableLiveData = MutableLiveData<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideStatusBarAndSupportBar()

        changeTextInRealTime()
        getSelectedItemInSpinner()
        observeTextLength()

        buttonCopyClick()
    }

    private fun buttonCopyClick() {
        button4.setOnClickListener {
            copyToClipboard(editTextTextOutput.text.toString())
            Toast.makeText(this, "Copiado!", Toast.LENGTH_LONG).show()
        }
    }

    private fun getSelectedItemInSpinner(): String {
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                setSelectedItemInSpinner()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        return spinner.selectedItem.toString()
    }

    private fun setSelectedItemInSpinner() {
        val convertCase = ConvertCase()

        if (spinner.selectedItem.toString() == "Letras maiúsculas") {
            editTextTextOutput.setText(editTextText.text.toString().toUpperCase())
        }
        if (spinner.selectedItem.toString() == "Letras minúsculas") {
            editTextTextOutput.setText(editTextText.text.toString().toLowerCase())
        }
        if (spinner.selectedItem.toString() == "Letras alternativas (1)") {
            editTextTextOutput.setText(
                convertCase.toAlternativeCase(
                    editTextText.text.toString(),
                    firstLetterUppercase = true
                )
            )
        }
        if (spinner.selectedItem.toString() == "Letras alternativas (2)") {
            editTextTextOutput.setText(
                convertCase.toAlternativeCase(
                    editTextText.text.toString(),
                    firstLetterUppercase = false
                )
            )
        }
        if (spinner.selectedItem.toString() == "Adicionar hífen") {
            editTextTextOutput.setText(convertCase.toHyphenCase(editTextText.text.toString()))
        }
        if (spinner.selectedItem.toString() == "Remover hífen") {
            editTextTextOutput.setText(convertCase.removeHyphenCase(editTextText.text.toString()))
        }
    }

    private fun hideStatusBarAndSupportBar() {
        supportActionBar!!.hide()
    }

    private fun changeTextInRealTime() {
        editTextText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(output: Editable) {
                setSelectedItemInSpinner()

                mutableLiveData.postValue(output.toString().isNotEmpty())
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

    private fun observeTextLength() {
        mutableLiveData.observe(this, Observer {
            editTextTextOutput.isEnabled = it
        })
    }

    private fun copyToClipboard(text: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        @Deprecated("")
        clipboard.text = text
    }

}
