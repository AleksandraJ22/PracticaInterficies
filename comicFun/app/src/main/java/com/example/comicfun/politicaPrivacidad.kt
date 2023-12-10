package com.example.comicfun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class politicaPrivacidad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.politica_de_privacidad)
    }


    fun aceptar_pdp_iniciar_sesion(view: View){

        val intent= Intent(this,iniciar_sesion::class.java).apply{}
        startActivity(intent);

    }





}