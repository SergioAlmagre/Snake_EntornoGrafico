package com.example.snake

import Auxiliar.Datos
import Auxiliar.Mensaje
import BBDD.Conexion
import Usuario.Usuario
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.stage.Modality
import javafx.stage.Stage

class LoginController {

    @FXML
    private lateinit var dniField: TextField

    @FXML
    private lateinit var entrarButton: Button

    @FXML
    private lateinit var usuarioField: TextField

    @FXML
    private lateinit var welcomeText: Label

    @FXML
    fun entrarButton(event: ActionEvent) {

        try {
            Datos.usuarioLogin = Conexion.obtenerUsuarioLogin(usuarioField.text, dniField.text)
            if (Datos.usuarioLogin != null) {
                if (Datos.usuarioLogin!!.tipo == 1) {
                    val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("administracion-view.fxml"))
                    val scene = Scene(fxmlLoader.load())
                    val stage = Stage()
                    stage.title = "Administracion"
                    stage.scene = scene
                    stage.initModality(Modality.APPLICATION_MODAL)
                    val stageLocal = dniField.scene.window as Stage
                    stageLocal.hide()
                    stage.showAndWait()
                } else {
                    val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("principal-view.fxml"))
                    val scene = Scene(fxmlLoader.load())
                    val stage = Stage()
                    stage.title = "A jugar!"
                    stage.scene = scene
                    stage.initModality(Modality.APPLICATION_MODAL)
                    val stageLocal = dniField.scene.window as Stage
                    stageLocal.hide()
                    stage.showAndWait()
                }
            } else {
                Mensaje.informativo("No se ha encontrado ningún usuario")
            }
        }catch (e:Exception){
            Datos.gestionErrores(e,"login")
        }

    }
}
