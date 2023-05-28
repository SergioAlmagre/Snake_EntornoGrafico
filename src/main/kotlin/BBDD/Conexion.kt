package BBDD

import Auxiliar.Datos
import Usuario.Usuario
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.util.LinkedList

object Conexion {
    var cod = 0

    // ********************* Atributos *************************
    var conexion: Connection? = null

    // Atributo a través del cual hacemos la conexión física.
    var sentenciaSQL: Statement? = null

    // Atributo que nos permite ejecutar una sentencia SQL
    var registros: ResultSet? = null



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

    fun obtenerUsuarioLogin(nombre:String,dni:String): Usuario?{
        var sentencia = "select * from usuarios where upper (nombre) like ? and upper (dni) like ?"
        var usu:Usuario? = null
        try {
            abrirConexion()

            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,nombre)
            pstmt.setString(2,dni)
            registros = pstmt.executeQuery()
            if (registros!!.next()){
                usu = Usuario(
                    registros!!.getString(1),
                    registros!!.getString(2),
                    registros!!.getInt(3),
                    registros!!.getInt(4),
                    registros!!.getInt(5),
                    registros!!.getInt(6)
                )
            }

            cerrarConexion()
        }catch (e:Exception){
            Datos.gestionErrores(e,sentencia)
        }
        return usu
    }

    fun obtenerAllUsuarios():LinkedList<Usuario?>{
        var sentencia = "select * from usuarios"
        var allUsu = LinkedList<Usuario?>()
        var usu:Usuario? = null
        try {
            abrirConexion()

            var pstmt = conexion!!.prepareStatement(sentencia)
            registros = pstmt.executeQuery()
            while (registros!!.next()){
                usu = Usuario(
                    registros!!.getString(1),
                    registros!!.getString(2),
                    registros!!.getInt(3),
                    registros!!.getInt(4),
                    registros!!.getInt(5),
                    registros!!.getInt(6),
                )
                allUsu.add(usu)
            }

            cerrarConexion()
        }catch (e:Exception){
            Datos.gestionErrores(e,sentencia)
        }
        return allUsu
    }










}