/*package com.example.comicfun

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.comicfun", appContext.packageName)
    }
}
*/
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




}


