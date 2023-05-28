package com.example.snake

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import javafx.scene.layout.Pane

class DetalleElementoController {

    @FXML
    private lateinit var colorComboBoxFX: ComboBox<Any>

    @FXML
    private lateinit var elementoFX: Pane

    @FXML
    private lateinit var guardarButtonFX: Button

    @FXML
    private lateinit var posicionField: TextField

    @FXML
    private lateinit var tipoComboBoxFX: ComboBox<Any>

    @FXML
    private lateinit var vidaField: TextField

    @FXML
    private lateinit var volverButtonFX: Button

    @FXML
    fun eliminarButton(event: ActionEvent) {

    }

    @FXML
    fun guardarButton(event: ActionEvent) {

    }

    @FXML
    fun volverButton(event: ActionEvent) {

    }

}
