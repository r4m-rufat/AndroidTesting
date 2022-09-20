package com.codingwithrufat.testing

import org.junit.Assert.*

import org.junit.Test

class CheckInputsTest {

    @Test
    fun `the username is already taken and should return false`() {

        val userParams = CheckInputs.register(
            "Rufat",
            "12345678",
            "12345678",
        )

        assertEquals(false, userParams)

    }

    @Test
    fun `the password length is less than 6 and should return false`() {

        val userParams = CheckInputs.register(
            "Agalar",
            "12345",
            "12345",
        )

        assertEquals(false, userParams)

    }

    @Test
    fun `the password doesn't equal to confirm password and should return false`() {

        val userParams = CheckInputs.register(
            "Agalar",
            "123458",
            "123456",
        )

        assertEquals(false, userParams)

    }

    /**
     * check existence of the username
     * check the password length
     * check the password equals to confirm password
     */

    @Test
    fun `must return true`() {

        val userParams = CheckInputs.register(
            "Agalar",
            "123456",
            "123456",
        )

        assertEquals(true, userParams)

    }

}