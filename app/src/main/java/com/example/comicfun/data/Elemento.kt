package com.example.comicfun.data


data class Elemento(
    val idElemento: Int?=null,
    val idPanel: Int? = null,
    val imagenElemento: Int?,
    val tipoElemento: String // burbuja, personaje, fondo
)
