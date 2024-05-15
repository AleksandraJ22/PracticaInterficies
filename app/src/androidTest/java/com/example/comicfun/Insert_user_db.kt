package com.example.comicfun

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class insert_user_db {
    private val context: Context = ApplicationProvider.getApplicationContext()
    private val dbHandler = DBHandler(context)

    @Test
    fun insertUsuario() {
       val user= Usuarios(  "eduardo",
            "gomez",
            "Hola123*",

            "edu33@gmail.com")

     val  usuario_creado : Boolean = dbHandler.insertUsuario(user)


        assertEquals(true,usuario_creado)

    }

 /*   @Test
    fun checkearUsuario() {
    }*/
}

