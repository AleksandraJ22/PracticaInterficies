package com.example.comicfun

class Usuarios {


    var ID : Int = 0
    var NOMBRE : String = ""
    var APELLIDO : String = ""
    var PASSWORD : String = ""

    var GMAIL: String = ""


    constructor(NOMBRE: String, APELLIDO: String, PASSWORD: String, GMAIL: String) {



        this.NOMBRE=NOMBRE
        this.APELLIDO = APELLIDO
        this.PASSWORD= PASSWORD
        this.GMAIL=GMAIL
    }
}