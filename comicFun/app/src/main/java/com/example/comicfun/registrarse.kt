package com.example.comicfun


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class registrarse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_registro)
    }


    fun volverPantallaInicio(view: View){

        val intent= Intent(this,MainActivity::class.java).apply{}
startActivity(intent);

    }

    fun continuarPoliticaPrivacidad(view: View){

        val intent= Intent(this,politicaPrivacidad::class.java).apply{}
        startActivity(intent);

    }





}