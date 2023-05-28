package Comida

class Fruta:Comida {
    var minerales:Int

    constructor(id: Int, caducidad: Int, minerales: Int) : super(id, caducidad) {
        this.minerales = minerales
    }

    override fun toString(): String {
        return "Fruta(minerales=$minerales)"
    }


}