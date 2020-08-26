package com.example.textcaseconversion.controller

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