package BBDD

import Auxiliar.Datos
import Serpiente.Elemento
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

    fun updateUsuario(usuario: Usuario):Int{
        cod = 0
        var sentencia = "update usuarios set nombre = ?, nivel = ?, victorias = ?, derrotas = ?, tipo = ? where dni like ?"
        try {
            abrirConexion()

            var pstmt = conexion!!.prepareStatement(sentencia)

            pstmt.setString(1,usuario.nombre)
            pstmt.setInt(2,usuario.nivel)
            pstmt.setInt(3,usuario.victorias)
            pstmt.setInt(4,usuario.derrotas)
            pstmt.setInt(5,usuario.tipo)
            pstmt.setString(6,usuario.dni)
            pstmt.executeUpdate()

            cerrarConexion()
            cod = 1
        }catch (e:Exception){
            Datos.gestionErrores(e,sentencia)
        }
        return cod
    }

    fun insertarUsuario(usuario: Usuario):Int{
        cod = 0
        var sentencia = "insert into usuarios values (?,?,?,?,?,?)"
        try {
            abrirConexion()

            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,usuario.dni)
            pstmt.setString(2,usuario.nombre)
            pstmt.setInt(3,usuario.nivel)
            pstmt.setInt(4,usuario.victorias)
            pstmt.setInt(5,usuario.derrotas)
            pstmt.setInt(6,usuario.tipo)
            pstmt.executeUpdate()

            cerrarConexion()
            cod = 1
        }catch (e:Exception){
            Datos.gestionErrores(e,sentencia)
        }
        return cod
    }

    fun eliminarUsuario(usuario: Usuario):Int{
        cod = 0
        var sentencia = "delete from usuarios where dni like ?"
        try {
            abrirConexion()

            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,usuario.dni)
            pstmt.executeUpdate()

            cerrarConexion()
        }catch (e:Exception){
            Datos.gestionErrores(e,sentencia)
        }
        return cod
    }

    fun obtenerAllElementos():LinkedList<Elemento?>{
        var sentencia = "select * from elementos"
        var allEle = LinkedList<Elemento?>()
        var ele:Elemento? = null
        try {
            abrirConexion()

            var pstmt = conexion!!.prepareStatement(sentencia)
            registros = pstmt.executeQuery()
            while (registros!!.next()){
                ele = Elemento(
                    registros!!.getInt(1),
                    registros!!.getInt(2),
                    registros!!.getInt(3),
                    registros!!.getString(4),
                    registros!!.getInt(5)
                )
                allEle.add(ele)
            }

            cerrarConexion()
        }catch (e:Exception){
            Datos.gestionErrores(e,sentencia)
        }
        return allEle
    }










}