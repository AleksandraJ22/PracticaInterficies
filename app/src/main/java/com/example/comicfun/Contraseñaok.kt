package com.example.comicfun


    object Contraseñaok {



        fun validContraseñaInput(
            pass1 : String,
            confirmPassword : String,

        ) : Boolean {

            var res = false
            if(pass1 == confirmPassword){
                val letra_mayuscula: Boolean = pass1.any { it.isUpperCase() }
                val cuantasLetras : Boolean = pass1.count() >= 6
                if(letra_mayuscula && cuantasLetras ){
                    res = true

                }
            }
            return res;
        }
    }
