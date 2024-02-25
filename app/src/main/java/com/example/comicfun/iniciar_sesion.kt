package com.example.comicfun


import android.content.Intent
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.coroutines.flow.internal.NoOpContinuation.context

class iniciar_sesion : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iniciar_sesion)
    }




    fun forgotPassword(view: View){


        val intent= Intent(this, forgotPass::class.java).apply{}
        startActivity(intent);
    }


    fun rememberMe(view:View){


        val intent= Intent(this, pantallaCrearEditarComic::class.java).apply{}
        startActivity(intent);

    }




}