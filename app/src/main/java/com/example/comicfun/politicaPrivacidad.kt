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
        setContentView(R.layout.politica_de_privacidad2)

        val checkBoxPrivacidad = findViewById<CheckBox>(R.id.checkBox2)
        val btnContinuar = findViewById<Button>(R.id.button2)

        btnContinuar.isEnabled = false

        checkBoxPrivacidad.setOnCheckedChangeListener { _, isChecked ->

            btnContinuar.isEnabled = isChecked
            if (isChecked) {

                btnContinuar.setOnClickListener{
                    signUp()


                }

            }

        }
    }



    fun aceptar_pdp_iniciar_sesion(view: View){

        val intent= Intent(this,pantallaCrearEditarComic::class.java).apply{}
        startActivity(intent);

    }


    fun signUp(){

            val intent = Intent(this, registrarse::class.java)
            startActivity(intent)

    }


}