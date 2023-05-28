package Juego

import Usuario.Usuario

class Partida {

    var usuario:Usuario?
    var mapa:Mapa?

    constructor(usuario: Usuario, mapa: Mapa) {
        this.usuario = usuario
        this.mapa = mapa
    }


}