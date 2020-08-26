package com.example.textcaseconversion.controller

import android.util.Log

class ConvertCase {

    fun toAlternativeCase(text: String, firstLetterUppercase: Boolean): String {
        return transformInAlternativeCase(text, firstLetterUppercase)
    }

    fun toHyphenCase(text: String): String {
        return transformInHyphenCase(text)
    }

    fun removeHyphenCase(text: String): String {
        return removeHyphenFromText(text)
    }

    fun toFormalCase(text: String): String {
        return transformInFormalText(text)
    }

    private fun transformInFormalText(text: String): String {
        var text = text
        //to-do here
        for (i in text.indices) {
            try {
                val nextCharAfterDot = text[i + 2].toString()
                if (text[i].toString() == ".") {
                    text = text.replace(
                        oldValue = nextCharAfterDot,
                        newValue = nextCharAfterDot.toUpperCase()
                    )
                }
            } catch (e: Exception) {
                //Exception ocorrerá sempre que o i + 2 alcançar um valor inexistente, no caso o
                //último ponto final da frase.
                Log.e("Error ", e.toString())
            }
        }
        return text
    }

    private fun transformInHyphenCase(text: String): String {
        return text.replace(oldValue = " ", newValue = "-")
    }

    private fun removeHyphenFromText(text: String): String {
        return text.replace(oldValue = "-", newValue = " ")
    }

    private fun transformInAlternativeCase(text: String, firstLetterUppercase: Boolean): String {
        var counter = 1
        if (firstLetterUppercase) counter = 0
        var alternativeText = ""
        for (i in text.indices) {
            if (counter == 0) {
                alternativeText += text[i].toUpperCase().toString()
                counter++
            } else {
                alternativeText += text[i].toLowerCase().toString()
                counter--
            }
        }
        return alternativeText
    }
}