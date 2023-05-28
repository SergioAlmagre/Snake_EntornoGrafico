package com.example.snake

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.CheckBox
import javafx.scene.control.ComboBox
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextField

class AdministracionController {

    @FXML
    private lateinit var checkConfirmacion: CheckBox

    @FXML
    private lateinit var comboSeleccion: ComboBox<Any>

    @FXML
    private lateinit var derrotasColum: TableColumn<Any, Any>

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
    private lateinit var nivelColum: TableColumn<Any, Any>

    @FXML
    private lateinit var nivelField: TextField

    @FXML
    private lateinit var nombreColum: TableColumn<Any, Any>

    @FXML
    private lateinit var nombreField: TextField

    @FXML
    private lateinit var tablaUsuarios: TableView<Any>

    @FXML
    private lateinit var tipoColum: TableColumn<Any, Any>

    @FXML
    private lateinit var tipoField: TextField

    @FXML
    private lateinit var victoriasColum: TableColumn<Any, Any>

    @FXML
    private lateinit var victoriasField: TextField

    @FXML
    private lateinit var volverButtonFX: Button

    @FXML
    fun ejecutarButton(event: ActionEvent) {

    }

    @FXML
    fun jugarButton(event: ActionEvent) {

    }

    @FXML
    fun volverButton(event: ActionEvent) {

    }

}
