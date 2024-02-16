package com.example.comicfun

import android.content.ContentValues
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.annotation.ContentView
import androidx.fragment.app.Fragment

class AgregarUsuarioFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewRoot : View = inflater.inflate(R.layout.pantalla_registro, container, false)


        val edUsuario_nombre = viewRoot.findViewById<EditText>(R.id.edit_text_nombre)
        val edUsuario_apellido = viewRoot.findViewById<EditText>(R.id.apellido)
        val edUsuario_correo = viewRoot.findViewById<EditText>(R.id.gmail_usuario)
        val edUsuario_pass1 = viewRoot.findViewById<EditText>(R.id.contraseña1)
        val edUsuario_pass2 = viewRoot.findViewById<EditText>(R.id.contraseña2)
        val btn_usuario_registrar = viewRoot.findViewById<Button>(R.id.boton_signUp)


        btn_usuario_registrar.setOnClickListener{

            //traemos bd
            val admin = BaseDatosApp(context, "bd",null,1) // con esto se crea bd ç
            val bd = admin.writableDatabase
            val reg = ContentValues()

            reg.put("ID",1)
            reg.put("NOMBRE",edUsuario_nombre.text.toString())
            reg.put("APELLIDO",edUsuario_apellido.text.toString())
            reg.put("GMAIL",edUsuario_correo.text.toString())
            reg.put("PASSWORD",edUsuario_pass1.text.toString())

            bd.insert("Usuarios", null, reg)
            bd.close()


        }
        return viewRoot
    }

}