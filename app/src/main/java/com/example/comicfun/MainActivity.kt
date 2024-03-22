package com.example.comicfun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var dbHandler: DBHandler
    //val db = DBHandler(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        dbHandler=DBHandler(this)
       // dbHandler.onCreate(dbHandler.writableDatabase)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_inicio)

        val btn_registro : Button = findViewById(R.id.button3)
        btn_registro.setOnClickListener{

            irAPoliticaDePrivacidad()

        }
    }

    fun signIn(view: View){
        val intent= Intent(this, iniciar_sesion::class.java).apply{}
        startActivity(intent);


    }



    fun irAPoliticaDePrivacidad(){

        val intent= Intent(this,politicaPrivacidad::class.java).apply{}
        startActivity(intent);


    }





}