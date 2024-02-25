package com.example.comicfun

class Usuarios {


    var ID : Int = 0
    var NOMBRE : String = ""
    var APELLIDO : String = ""
    var PASSWORD : String = ""

    var GMAIL: String = ""

/*

    fun setNombre(nombre: String){
        this.NOMBRE=nombre
    }

    fun getNombre(): String{
        return this.NOMBRE
    }

    fun setApellido(apellido: String){
        this.APELLIDO=apellido
    }
fun getApellido(): String{

    return this.APELLIDO
}

    fun getPassword(): String{
        return this.PASSWORD
    }
    fun setPass(pass: String){
        this.PASSWORD=pass
    }

*/
    constructor(NOMBRE: String, APELLIDO: String, PASSWORD: String, GMAIL: String) {



        this.NOMBRE=NOMBRE
        this.APELLIDO = APELLIDO
        this.PASSWORD= PASSWORD
        this.GMAIL=GMAIL
    }
}