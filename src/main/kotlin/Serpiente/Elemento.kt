package Serpiente

data class Elemento(val idElemento: Int ,val vida:Int, val posicion:Int, var color:String, var tipo:Int) {

    override fun toString(): String {
        var cad = ""
        if (color == "amarillo"){
            cad = "A"
        }
        else if(color == "naranja"){
            cad = "N"
        }
        else if(color == "naranja"){
            cad = "N"
        }
        else if(color == "azul"){
            cad = "A"
        }
        else if(color == "verde"){
            cad = "V"
        }
        else if(color == "rojo"){
            cad = "R"
        }
        return cad
    }
}