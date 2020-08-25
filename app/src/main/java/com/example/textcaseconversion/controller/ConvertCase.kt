package com.example.textcaseconversion.controller

class ConvertCase {

    fun toAlternativeCase(text: String, firstLetterUppercase: Boolean): String {
        return transformInAlternativeCase(text, firstLetterUppercase)
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