package com.example.comicfun

import org.junit.Assert.*
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class ContraseñaokTest{

    @Test
    fun `contrasenya coincide`(){

        val result : Boolean = Contraseñaok.validContraseñaInput(
            "Hola12","Hola12"
        )
        // assertThat() comes from the truth library that we added earlier
        // put result in it and assign the boolean that it should return
       assertEquals(true,result)
    }

    @Test
    fun `contrasenya coincide pero no tiene caracteres suficientes`(){

        val result : Boolean = Contraseñaok.validContraseñaInput(
            "Hola1","Hola1"
        )
        // assertThat() comes from the truth library that we added earlier
        // put result in it and assign the boolean that it should return
        assertEquals(false,result)
    }


    @Test
    fun `contrasenya no coincide`(){

        val result : Boolean = Contraseñaok.validContraseñaInput(
            "Hola1","Hola1233344"
        )
        // assertThat() comes from the truth library that we added earlier
        // put result in it and assign the boolean that it should return
        assertEquals(false,result)
    }


    @Test
    fun `contrasenya coincide pero le falta mayuscula`(){

        val result : Boolean = Contraseñaok.validContraseñaInput(
            "hola12","hola12"
        )
        // assertThat() comes from the truth library that we added earlier
        // put result in it and assign the boolean that it should return
        assertEquals(false,result)
    }



}