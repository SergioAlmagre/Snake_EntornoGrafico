package BBDD

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

object Conexion {

    // ********************* Atributos *************************
    var conexion: Connection? = null

    // Atributo a través del cual hacemos la conexión física.
    var sentenciaSQL: Statement? = null

    // Atributo que nos permite ejecutar una sentencia SQL
    var registros: ResultSet? = null

    var cod = 0


    fun abrirConexion(): Int {
        var cod = 0
        try {
            // Cargar el driver/controlador JDBC de MySql
            val controlador = "com.mysql.cj.jdbc.Driver"
            val URL_BD = "jdbc:mysql://" + Constantes.servidor + ":" + Constantes.puerto + "/" + Constantes.bbdd
            Class.forName(controlador)

            // Realizamos la conexión a una BD con un usuario y una clave.
            conexion = DriverManager.getConnection(URL_BD, Constantes.usuario, Constantes.passwd)
            sentenciaSQL = conexion!!.createStatement()
//            println("Conexion realizada con éxito")
        } catch (e: Exception) {
//            Datos.gestionErrores(e,"Fallo en abrir conexión")
        }
        return cod
    }

    fun cerrarConexion(): Int {
        var cod = 0
        try {
            conexion!!.close()

        } catch (e: Exception) {
//            Datos.gestionErrores(e,"Fallo en cerrar conexión")
        }
        return cod
    }
}