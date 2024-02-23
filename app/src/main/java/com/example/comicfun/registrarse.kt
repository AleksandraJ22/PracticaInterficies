package com.example.comicfun


import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class registrarse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_registro)
        val btn_usuario_registrar : Button = findViewById(R.id.boton_signUp)
        val edUsuario_nombre : EditText = findViewById(R.id.edit_text_nombre)
        val edUsuario_apellido : EditText=findViewById(R.id.apellido)
        val edUsuario_correo : EditText = findViewById(R.id.gmail_usuario)
        val edUsuario_pass1 : EditText = findViewById(R.id.contraseña1)
        val edUsuario_pass2: EditText =findViewById(R.id.contraseña2)

        btn_usuario_registrar.setOnClickListener{

if((edUsuario_pass1==edUsuario_pass2) && edUsuario_pass1.length() > 0 && edUsuario_nombre.length() > 0
    && edUsuario_apellido.length() > 0 && edUsuario_correo.length() >0){

var user = Usuarios(edUsuario_nombre.text.toString(), edUsuario_apellido.text.toString(),
    edUsuario_pass1.text.toString(),edUsuario_correo.text.toString())
var db = DBHandler(this)
    db.insertData(user)

}else{
Toast.makeText(this, "Por favor rellena todos los campos",Toast.LENGTH_SHORT).show()

}


        }
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