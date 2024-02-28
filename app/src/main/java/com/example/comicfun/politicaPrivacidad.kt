package com.example.comicfun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class politicaPrivacidad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.politica_de_privacidad)


        val checkBoxPrivacidad = findViewById<CheckBox>(R.id.checkBox)


        val btnContinuar = findViewById<Button>(R.id.button2)
        btnContinuar.isEnabled = checkBoxPrivacidad.isChecked
        checkBoxPrivacidad.setOnCheckedChangeListener { _, isChecked ->
            btnContinuar.isEnabled = isChecked
        }
    }



    fun aceptar_pdp_iniciar_sesion(view: View){

        val intent= Intent(this,pantallaCrearEditarComic::class.java).apply{}
        startActivity(intent);

    }


    fun signUp(view: View){

        val checkBoxPrivacidad = findViewById<CheckBox>(R.id.checkBox)

        if (checkBoxPrivacidad.isChecked) {
            val intent = Intent(this, registrarse::class.java)
            startActivity(intent)
        } else {

            Toast.makeText(this, "Por favor, acepta los términos de privacidad", Toast.LENGTH_SHORT).show()
        }
    }


}