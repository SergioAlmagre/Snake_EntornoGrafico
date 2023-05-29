package com.example.snake

import Auxiliar.Datos
import Auxiliar.Mensaje
import BBDD.Conexion
import Usuario.Usuario
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.input.MouseEvent
import javafx.stage.Modality
import javafx.stage.Stage
import java.awt.event.ActionListener
import java.net.URL
import java.util.*
import javax.swing.Timer

class AdministracionController:Initializable {

    var hayCambios:Boolean = false

    var tiempo = 1
    var contador = 60

    companion object {
        lateinit var temporizador: Timer
    }


    @FXML
    private lateinit var checkConfirmacion: CheckBox

    @FXML
    private lateinit var comboSeleccion: ComboBox<Any>

    @FXML
    private lateinit var derrotasColum: TableColumn<Usuario, String>

    @FXML
    private lateinit var derrotasField: TextField

    @FXML
    private lateinit var dniColum: TableColumn<Any, Any>

    @FXML
    private lateinit var dniField: TextField

    @FXML
    private lateinit var ejecutarButtonFX: Button

    @FXML
    private lateinit var jugarButtonFX: Button

    @FXML
    private lateinit var nivelColum: TableColumn<Usuario, String>

    @FXML
    private lateinit var nivelField: TextField

    @FXML
    private lateinit var nombreColum: TableColumn<Usuario, String>

    @FXML
    private lateinit var nombreField: TextField

    @FXML
    private lateinit var tablaUsuarios: TableView<Usuario>

    @FXML
    private lateinit var tipoColum: TableColumn<Usuario, String>

    @FXML
    private lateinit var tipoField: TextField

    @FXML
    private lateinit var victoriasColum: TableColumn<Usuario, String>

    @FXML
    private lateinit var victoriasField: TextField

    @FXML
    private lateinit var volverButtonFX: Button

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        try {
            var allUsuarios = Conexion.obtenerAllUsuarios()


            nombreColum.cellValueFactory = PropertyValueFactory("nombre")
            dniColum.cellValueFactory = PropertyValueFactory("dni")
            nivelColum.cellValueFactory = PropertyValueFactory("nivel")
            victoriasColum.cellValueFactory = PropertyValueFactory("victorias")
            derrotasColum.cellValueFactory = PropertyValueFactory("derrotas")
            tipoColum.cellValueFactory = PropertyValueFactory("tipo")

            tablaUsuarios.items.addAll(allUsuarios)

            var acciones = listOf("Modificar","Añadir","Eliminar")
            comboSeleccion.promptText = "Seleccione..."
            comboSeleccion.items.addAll(acciones)

            nombreField.textProperty().addListener { _, _, _ -> cambios() }
            dniField.textProperty().addListener { _, _, _ -> cambios() }
            victoriasField.textProperty().addListener { _, _, _ -> cambios() }
            victoriasField.textProperty().addListener { _, _, _ -> cambios() }
            derrotasField.textProperty().addListener { _, _, _ -> cambios() }
            tipoField.textProperty().addListener { _, _, _ -> cambios() }

            temporizador = Timer(1000, object : ActionListener {
                override fun actionPerformed(e: java.awt.event.ActionEvent?) {

                }
            })

    }catch (e:Exception){
            Datos.gestionErrores(e,"inicializer de Administracion")
        }
    }


    @FXML
    fun ejecutarButton(event: ActionEvent) {
        try {
            var index = comboSeleccion.selectionModel.selectedIndex
            println(index)
            if (comprobarIntegridad(index)) {
                if (index == 0){
                    Conexion.updateUsuario(Datos.usuarioAux!!)
                    Mensaje.informativo("Usuario actualizado con éxito")
                    actualizarTablaUsuarios()
                    hayCambios = false
                }
                else if (index == 1){
                    Conexion.insertarUsuario(Datos.usuarioAux!!)
                    Mensaje.informativo("Usuario insertado con éxito")
                    actualizarTablaUsuarios()
                    hayCambios = false
                }
                else if (index == 2){
                    Conexion.eliminarUsuario(Datos.usuarioAux!!)
                    Mensaje.informativo("Usuario borrado con éxito")
                    actualizarTablaUsuarios()
                    hayCambios = false
                }
            }
            checkConfirmacion.isSelected = false
        }catch (e:Exception){
            Datos.gestionErrores(e,"ejecutarButton")
        }
    }

    @FXML
    fun jugarButton(event: ActionEvent) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("principal-view.fxml"))
        val scene = Scene(fxmlLoader.load())
        val stage = Stage()
        stage.title = "A jugar!"
        stage.scene = scene
        stage.initModality(Modality.APPLICATION_MODAL)
//        val stageLocal = dniField.scene.window as Stage
//        stageLocal.hide()
        stage.showAndWait()
    }

    @FXML
    fun salirAplicacion(event: ActionEvent) {
        if (hayCambios){
            if (Mensaje.alerta("¿Ha realizado cambios, realmente desea salir de la aplicación?") == ButtonType.YES){
                val stage = dniField.scene.window as Stage
                stage.close()
            }else{
                val stage = dniField.scene.window as Stage
                stage.close()
            }
        }else{
            if (Mensaje.alerta("¿Desea salir realmente de la aplicación?") == ButtonType.YES){
                val stage = dniField.scene.window as Stage
                stage.close()
            }
        }
    }
    @FXML
    fun onMouseClickTabla(event: MouseEvent) {
        var usu:Usuario? = tablaUsuarios.selectionModel.selectedItem
        try{
            nombreField.text = usu!!.nombre
            dniField.text = usu.dni
            nivelField.text = usu.nivel.toString()
            victoriasField.text = usu.nivel.toString()
            derrotasField.text = usu.nivel.toString()
            tipoField.text = usu.tipo.toString()
            hayCambios = false
        }catch (e:Exception){
            Datos.gestionErrores(e,"OnmouseClickTabla")
        }
    }

    fun cambios(){
        hayCambios = true
    }

    @FXML
    fun actionComboBox(event: ActionEvent) {
        var allFields = listOf(nombreField,dniField,nivelField,victoriasField,derrotasField,tipoField)

        if(comboSeleccion.selectionModel.selectedIndex == 0){
            for (e in allFields){
                e.style = "-fx-background-color: CCFFFC;"
            }
            dniField.isDisable = true
        }

        if (comboSeleccion.selectionModel.selectedIndex == 1){
            for (e in allFields){
                e.text = null
                e.style = "-fx-background-color: DEFFCC;"
            }
            dniField.isDisable = false
        }

        if(comboSeleccion.selectionModel.selectedIndex == 2){
            for (e in allFields){
                e.style = "-fx-background-color: FFCCCC;"
            }
            dniField.isDisable = false
        }
    }

    fun comprobarIntegridad(index:Int):Boolean{
        var completo = true

        if (index != -1){
            if (hayCambios || index == 1 || index == 2) {
                var usu: Usuario? = tablaUsuarios.selectionModel.selectedItem
                if (usu != null) {
                    usu!!.nombre = nombreField.text
                    usu!!.dni = dniField.text
                    usu!!.nivel = nivelField.text.toInt()
                    usu!!.victorias = victoriasField.text.toInt()
                    usu!!.derrotas = derrotasField.text.toInt()
                    usu!!.tipo = tipoField.text.toInt()
                } else {
                    Mensaje.informativo("No ha seleccionado ningún usuario")
                }
                if (usu!!.dni.isBlank() || usu.nombre.isBlank()) {
                    Mensaje.informativo("Debe rellenar obligatoriamente los campos NOMBRE y DNI")
                    completo = false
                } else if (usu.tipo > 1) {
                    Mensaje.informativo("Los tipos no pueden superar el 1")
                    completo = false
                } else if (usu.dni.length > 10) {
                    Mensaje.informativo("El DNI no puede superar los 10 dígitos")
                    completo = false
                } else if (!checkConfirmacion.isSelected) {
                    Mensaje.informativo("Por favor, marque el check para poder realizar cualquier cambio")
                    completo = false
                }else if(completo){
                    Datos.usuarioAux = usu
                }
            } else {
                Mensaje.informativo("No ha realizado ningún cambio para poder ejecutar ninguna acción")
                completo = false
            }
        }else{
            Mensaje.informativo("Seleccione primero una acción antes de ejecutar")
            completo = false
        }
        println(Datos.usuarioAux)
        println(completo)
        return completo
    }

    fun actualizarTablaUsuarios(){
        tablaUsuarios.items.clear()
        tablaUsuarios.items.addAll(Conexion.obtenerAllUsuarios())
    }







}
