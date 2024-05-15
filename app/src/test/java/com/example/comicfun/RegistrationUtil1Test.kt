package com.example.comicfun

import org.junit.Assert.*
import org.junit.Test


import org.mockito.Mockito


class RegistrationUtil1Test {


  ///  private lateinit var mockDbHandler: DBHandler

  /*  @Before
    fun setup() {
        mockDbHandler = Mockito.mock(DBHandler::class.java)

        RegistrationUtil1.dbHandler = mockDbHandler
        // Inicializa otras dependencias si es necesario
    }*/
    @Test
    fun testInsertarUsuarioBD(){
        // Pass the value to the function of RegistrationUtil class
        // since RegistrationUtil is an object/ singleton we do not need to create its object
      val result = RegistrationUtil1.validRegistrationInput(Usuarios(  "eduardo",
          "gomez",
          "Hola123*",

          "edu33@gmail.com"))

     // val context = this
    //  val result = RegistrationUtil1.registerUser(context, user)
    /*    val result = RegistrationUtil1.validRegistrationInput(

            "",
            "gomez",
            "Hola123*",
            "Hola123*",
            "edu33@gmail.com"
        )*/

        assertEquals(true,result)
    }

    /*
    @Test
    fun `register user calls insertarUsuario and returns true`() {
        val user = Usuarios(
            "eduardo",
            "gomez",
            "Hola123*",
            "eduGomez33@gmail.com"
        )

        // Configura el comportamiento simulado de insertarUsuario para devolver true
        Mockito.`when`(mockDbHandler.insertUsuario(user)).thenReturn(true)

        // Llama al método que quieres probar
        val result = RegistrationUtil1.registerUser(user)

        // Verifica que el método devuelva true
        assertTrue(result)

        // Verifica que se haya llamado al método insertarUsuario con el usuario correcto
        Mockito.verify(mockDbHandler).insertUsuario(user)
    }

    @Test
    fun `register user calls insertarUsuario and returns false`() {
        val user = RegistrationUtil1.Usuarios("Nombre", "Apellido", "password123", "nuevoemail@example.com")

        Mockito.`when`(mockDbHandler.insertarUsuario(user)).thenReturn(false)

        val result = RegistrationUtil1.registerUser(mockContext, user)

        assertFalse(result)
        Mockito.verify(mockDbHandler).insertarUsuario(user)
    }

    @Test
    fun `validRegistrationInput returns false for invalid input`() {
        val result = RegistrationUtil1.validRegistrationInput(
            name = "",
            apellido = "Apellido",
            password = "password123",
            confirmPassword = "password123",
            gmail = "email@example.com"
        )
        assertFalse(result)
    }

    @Test
    fun `validRegistrationInput returns true for valid input`() {
        val result = RegistrationUtil1.validRegistrationInput(
            name = "Nombre",
            apellido = "Apellido",
            password = "password123",
            confirmPassword = "password123",
            gmail = "nuevoemail@example.com"
        )
        assertTrue(result)
    }*/
}
