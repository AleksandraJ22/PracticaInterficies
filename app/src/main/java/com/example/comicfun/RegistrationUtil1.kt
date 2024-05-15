package com.example.comicfun

import android.content.Context
import com.example.comicfun.Usuarios

import com.example.comicfun.data.*

object RegistrationUtil1 {

    private val existingUsers = listOf("usuario1@gmail.com", "usuario2@gmail.com")

    private lateinit var dbHandler: DBHandler

    fun initialize(context: Context) {
        dbHandler = DBHandler(context)
    }

    fun validRegistrationInput(
        user: Usuarios
     /*   name: String,
        apellido: String,
        password: String,
        confirmPassword: String,
        gmail: String*/
    ): Boolean {
        return dbHandler.insertUsuario(user)


        /* if (  user.NOMBRE.isEmpty() || user.APELLIDO.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || gmail.isEmpty()) {
            return false
        }

        if (!gmail.contains("@")) {
            return false
        }

        if (password != confirmPassword) {
            return false
        }

        if (password.count { it.isDigit() } < 2) {
            return false
        }

        if (existingUsers.contains(gmail)) {
            return false
        }

*/
    }

  /*  fun registerUser(context: Context, user: Usuarios): Boolean {
        initialize(context)
        return dbHandler.insertUsuario(user)
    }*/
}
