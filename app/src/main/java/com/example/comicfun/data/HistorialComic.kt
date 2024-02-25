package com.example.comicfun.data

data class HistorialComic(
    val idHistorialComic: Int,
    val idUsuario: Int,
    val idComic: Int,

) {
    constructor(idUsuario: Int, idComic: Int) : this(0, idUsuario, idComic)
}
