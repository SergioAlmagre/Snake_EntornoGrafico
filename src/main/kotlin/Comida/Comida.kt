package Comida

open class Comida {
    var id:Int
    var caducidad:Int

    constructor(id: Int, caducidad: Int) {
        this.id = id
        this.caducidad = caducidad
    }

    override fun toString(): String {
        return "Comida(id=$id, caducidad=$caducidad)"
    }

}