package com.example.textcaseconversion.controller

class ConvertCase {

    fun toAlternativeCase(text: String): String {
        return transformInAlternativeCase(text)
    }

    private fun transformInAlternativeCase(text: String): String {
        var counter = 0
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