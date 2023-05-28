package Comida

class Veneno:Comida {

    var toxicos:Int

    constructor(id: Int, caducidad: Int, toxicos: Int) : super(id, caducidad) {
        this.toxicos = toxicos
    }

    override fun toString(): String {
        return "Veneno(toxicos=$toxicos)"
    }


}