package com.example.comicfun


import android.content.Intent
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class iniciar_sesion : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iniciar_sesion)

        val usuario : EditText = findViewById(R.id.editText)
        val contraseña: EditText = findViewById(R.id.editTextTextPassword)

        val DB = DBHandler(this)

        val btn_login: Button = findViewById(R.id.button4)
        btn_login.setOnClickListener{
            val user = usuario.text.toString()
            val password = contraseña.text.toString()

            if(user.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Por favor rellena todos los campos",Toast.LENGTH_SHORT).show()
            } else {

                val userData = DB.getUserData(user, password)
                if(userData != null) {
                    Toast.makeText(this, "LogIn correcto",Toast.LENGTH_SHORT).show()

                    UserManager.currentUser = userData

                    val intent= Intent(this, pantallaCrearEditarComic::class.java)

                    intent.putExtra("USERNAME", user)

                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "LogIn incorrecto",Toast.LENGTH_SHORT).show()
                }
            }
        }

        /*
                btn_login.setOnClickListener{


                    val user = usuario.getText().toString()
                    val contraseña = contraseña.text.toString()
                    if(user.isBlank() || contraseña.isBlank())

                    {
                        Toast.makeText(this, "Por favor rellena todos los campos",Toast.LENGTH_SHORT).show()
                    }else{
                        val checkUser = DB.loginCheckUser(user, contraseña)
                        if(checkUser){

                            Toast.makeText(this, "LogIn correcto",Toast.LENGTH_SHORT).show()


                            UserManager.currentUser = user

                            val intent= Intent(this, pantallaCrearEditarComic::class.java).apply{}
                            startActivity(intent);
                            finish()

                        }else{

                            Toast.makeText(this, "LogIn incorrecto",Toast.LENGTH_SHORT).show()
                        }
                    }

                }*/

    }
    fun forgotPassword(view: View){


        val intent= Intent(this, forgotPass::class.java).apply{}
        startActivity(intent);
    }


    fun rememberMe(view:View){


        val intent= Intent(this, pantallaCrearEditarComic::class.java).apply{}

        startActivity(intent);

    }


    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iniciar_sesion)

        val usuario : EditText = findViewById(R.id.editText)
        val contraseña: EditText = findViewById(R.id.editTextTextPassword)
val DB = DBHandler(this)

        val btn_login: Button = findViewById(R.id.button4)

        btn_login.setOnClickListener{


val user = usuario.getText().toString()
            val contraseña = contraseña.text.toString()
if(user.isBlank() || contraseña.isBlank())

{
    Toast.makeText(this, "Por favor rellena todos los campos",Toast.LENGTH_SHORT).show()
}else{
    val checkUser = DB.comprobarDatosLogin(user,contraseña)
    if(checkUser==true){

        Toast.makeText(this, "LogIn correcto",Toast.LENGTH_SHORT).show()
        val intent= Intent(this, pantallaCrearEditarComic::class.java).apply{}
        startActivity(intent);

    }else{

        Toast.makeText(this, "LogIn incorrecto",Toast.LENGTH_SHORT).show()
    }
}

        }

    }
    fun forgotPassword(view: View){


        val intent= Intent(this, forgotPass::class.java).apply{}
        startActivity(intent);
    }


    fun rememberMe(view:View){


        val intent= Intent(this, pantallaCrearEditarComic::class.java).apply{}
        startActivity(intent);

    }
*/

}