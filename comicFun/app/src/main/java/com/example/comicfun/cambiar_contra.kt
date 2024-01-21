package com.example.comicfun

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class cambiar_contra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_cambiar_contra_oficial)
    }

    fun volverAIniciarSesion(view:View){

            val intent= Intent(this, iniciar_sesion::class.java).apply{}
            startActivity(intent);

        }

    }


