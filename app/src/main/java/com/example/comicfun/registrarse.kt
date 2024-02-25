package com.example.comicfun


import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class registrarse : AppCompatActivity() {
    val db = DBHandler(this)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_registro)
        val btn_usuario_registrar : Button = findViewById(R.id.boton_signUp)
        val edUsuario_nombre : EditText = findViewById(R.id.edit_text_nombre)
        val edUsuario_apellido : EditText=findViewById(R.id.apellido)
        val edUsuario_correo : EditText = findViewById(R.id.gmail_usuario)
        val edUsuario_pass1 : EditText = findViewById(R.id.contraseña1)
        val edUsuario_pass2: EditText =findViewById(R.id.contraseña2)
       // val activityContext = this.applicationContext.writableDatabase

        btn_usuario_registrar.setOnClickListener{
            val pass1 = edUsuario_pass1.text.toString()
            val pass2 = edUsuario_pass2.text.toString()

            if (pass1 == pass2 && pass1.length >= 6 && pass1.any { it.isUpperCase() } && pass1.any { it.isLowerCase() } &&
                edUsuario_nombre.text.isNotEmpty() && edUsuario_apellido.text.isNotEmpty() && edUsuario_correo.text.isNotEmpty()) {

                val user = Usuarios(
                    edUsuario_nombre.text.toString(),
                    edUsuario_apellido.text.toString(),
                    pass1,
                    edUsuario_correo.text.toString()
                )


               // Toast.makeText(this, "Llamada a insertData", Toast.LENGTH_SHORT).show()
                db.insertData(user)

            } else if (pass1!=pass2){
                Toast.makeText(this, "Las  contraseña tiene coincidir", Toast.LENGTH_LONG).show()

            } else if(pass1.length <6  || !pass1.any { it.isUpperCase() } || !pass1.any { it.isLowerCase() } ){
                Toast.makeText(this, "La contraseña tiene que tener minimo 6 caracteres. Una mayuscula y minuscula", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Por favor rellena todos los campos correctamente", Toast.LENGTH_SHORT).show()

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