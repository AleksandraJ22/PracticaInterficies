package com.example.comicfun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_inicio)
    }

    fun signIn(view: View){
        val intent= Intent(this, iniciar_sesion::class.java).apply{}
        startActivity(intent);


    }

    fun signUp(view: View){



        val intent= Intent(this,registrarse::class.java).apply{}
        startActivity(intent);
    }








}