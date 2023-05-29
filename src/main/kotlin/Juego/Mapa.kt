package Juego

class Mapa {
    var cuadricula:Array<Array<Celda>> = Array(18){ Array(9){Celda()}}


    fun getFilas():Int{
        return cuadricula.size-1
    }

    fun getColumnas():Int{
        return cuadricula[0].size-1
    }

    fun getPosicion(fil:Int, col:Int):Any?{
        return cuadricula[fil][col].contenidoCelda
    }

    fun setPosicion(fil:Int, col: Int, objeto:Any?){
        cuadricula[fil][col].contenidoCelda = objeto
    }







}