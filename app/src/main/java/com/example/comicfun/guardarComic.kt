package com.example.comicfun



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class guardarComic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guardar_comic)
    }


    fun irAInicio(view:View){

            val intent= Intent(this,pantallaCrearEditarComic::class.java).apply{}
            startActivity(intent);

    }





}