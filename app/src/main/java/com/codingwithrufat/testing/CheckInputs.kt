package com.codingwithrufat.testing

object CheckInputs {

    private val list = listOf("Rufat", "Ulvi")

    fun register(
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean {

        if (list.contains(username))
            return false

        if (password.length < 6)
            return false

        if (password != confirmPassword)
            return false

        return true

    }

}