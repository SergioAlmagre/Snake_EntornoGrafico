package Auxiliar

import BBDD.Conexion
import Juego.Partida
import Usuario.Usuario
import java.io.File
import java.io.FileWriter
import java.time.LocalDate
import java.time.LocalTime

object Datos {

    var partida:Partida? = null
    var usuarioAux: Usuario? = null


    fun gestionErrores(excepcion:Exception,informacion:String){
        var fecha = LocalDate.now().toString()
        var hora = LocalTime.now().toString()
        var guion = " - "
        var mensaje = fecha + guion + hora + guion + excepcion.toString() + guion + informacion

        var archivo = File("BitacoraErrores")
        var writer = FileWriter(archivo,true)
        writer.write(mensaje)
        writer.close()
        Conexion.cod = -1
        println(mensaje)
    }

}