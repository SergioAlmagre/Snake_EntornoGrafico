package com.example.snake

import Auxiliar.Datos
import BBDD.Conexion
import Juego.Fila
import Juego.Partida
import Serpiente.Elemento
import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.input.MouseEvent
import java.awt.event.ActionListener
import java.net.URL
import java.util.*
import javax.swing.Timer


class PrincipalController:Initializable {
//    PARA DESARROLLAR MÁS RÁPIDO, INSTANCIO DESDE AQUÍ USUARIOLOGIN
    init {
        Datos.usuarioLogin = Conexion.obtenerUsuarioLogin("gamer","gamer")
    }
    var partida = Partida(Datos.usuarioLogin!!)
    var posicionClick =Array<Int>(2){0}
    var tiempo = 1
    var contador = 60
    var allElementos = Conexion.obtenerAllElementos()
    var filAct = 9
    var colAct = 4

    /**
     * direccion
     * 1 - izquierda
     * 2 - derecha
     * 3 - arriba
     * 4 - abajo
     */
    var direccion:Int = 0

    companion object {
        lateinit var temporizador: Timer
    }


    @FXML
    private lateinit var c1: TableColumn<Elemento, String>

    @FXML
    private lateinit var c2: TableColumn<Elemento, String>

    @FXML
    private lateinit var c3: TableColumn<Elemento, String>

    @FXML
    private lateinit var c4: TableColumn<Elemento, String>

    @FXML
    private lateinit var c5: TableColumn<Elemento, String>

    @FXML
    private lateinit var c6: TableColumn<Elemento, String>

    @FXML
    private lateinit var c7: TableColumn<Elemento, String>

    @FXML
    private lateinit var c8: TableColumn<Elemento, String>

    @FXML
    private lateinit var c9: TableColumn<Elemento, String>

    @FXML
    private lateinit var ganadasField: TextField

    @FXML
    private lateinit var longitudField: TextField

    @FXML
    private lateinit var nivelField: TextField

    @FXML
    private lateinit var perdidasField: TextField

    @FXML
    private lateinit var progressBar: ProgressBar

    @FXML
    private lateinit var tableTableroJuego: TableView<Any>

    @FXML
    private lateinit var usuarioField: TextField

    @FXML
    private lateinit var pauseRadio: RadioButton

    @FXML
    private lateinit var playRadio: RadioButton

    @FXML
    private lateinit var reiniciarRadio: RadioButton

    @FXML
    private lateinit var derechaFX: Button

    @FXML
    private lateinit var izquierdaFX: Button

    @FXML
    private lateinit var abajoFX: Button

    @FXML
    private lateinit var arribaFX: Button



    override fun initialize(p0: URL?, p1: ResourceBundle?) {

    try {
        usuarioField.text = Datos.usuarioLogin!!.nombre
        ganadasField.text = Datos.usuarioLogin!!.victorias.toString()
        perdidasField.text = Datos.usuarioLogin!!.derrotas.toString()

        progressBar.progress = 60.0

        pauseRadio.isSelected = true


        c1.cellValueFactory = PropertyValueFactory("c1")
        c2.cellValueFactory = PropertyValueFactory("c2")
        c3.cellValueFactory = PropertyValueFactory("c3")
        c4.cellValueFactory = PropertyValueFactory("c4")
        c5.cellValueFactory = PropertyValueFactory("c5")
        c6.cellValueFactory = PropertyValueFactory("c6")
        c7.cellValueFactory = PropertyValueFactory("c7")
        c8.cellValueFactory = PropertyValueFactory("c8")
        c9.cellValueFactory = PropertyValueFactory("c9")

        tableTableroJuego.selectionModel.cellSelectionEnabledProperty().set(true)
        tableTableroJuego.selectionModel.selectionMode = SelectionMode.SINGLE

        posicionarPrimerElemento()
        tableTableroJuego.items.clear()
        for (i in 0..partida.mapa.getFilas() - 1) {

            val fila = Fila(
                partida.mapa.getPosicion(i, 0)?.toString() ?: "",
                partida.mapa.getPosicion(i, 1)?.toString() ?: "",
                partida.mapa.getPosicion(i, 2)?.toString() ?: "",
                partida.mapa.getPosicion(i, 3)?.toString() ?: "",
                partida.mapa.getPosicion(i, 4)?.toString() ?: "",
                partida.mapa.getPosicion(i, 5)?.toString() ?: "",
                partida.mapa.getPosicion(i, 6)?.toString() ?: "",
                partida.mapa.getPosicion(i, 7)?.toString() ?: "",
                partida.mapa.getPosicion(i, 8)?.toString() ?: ""
            )
            tableTableroJuego.items.add(fila)
        }


        temporizador = Timer(1000, object : ActionListener {
            override fun actionPerformed(e: java.awt.event.ActionEvent?) {
                if (playRadio.isSelected) {
                    progressBar.progress = contador.toDouble() / 60
                    println(contador)
                    contador--
                Platform.runLater{
                    when(direccion){
                        1->movimientoIzquierda()
                        2->movimientoDerecha()
                        3->movimientoArriba()
                        4->movimientoAbajo()
                    }
                }

                }


                tiempo++
            }
        })
        temporizador.start()

    }catch (e:Exception){
        Datos.gestionErrores(e,"Inicializer PrincipalController")
            }
    }




    @FXML
    fun aboutMenu(event: ActionEvent) {

    }
    @FXML
    fun arribaButton(event: ActionEvent) {
        movimientoArriba()
    }
    @FXML
    fun abajoButton(event: ActionEvent) {
        movimientoAbajo()
    }
    @FXML
    fun izquierdaButton(event: ActionEvent) {
       movimientoIzquierda()

    }
    @FXML
    fun derchaButton(event: ActionEvent) {
        movimientoDerecha()
    }

    @FXML
    fun exportarPartidaMenu(event: ActionEvent) {

    }

    @FXML
    fun guardarPartidaMenu(event: ActionEvent) {

    }

    @FXML
    fun importarPartidaMenu(event: ActionEvent) {

    }

    @FXML
    fun instruccionesMenu(event: ActionEvent) {

    }



    @FXML
    fun salirJuegoMenu(event: ActionEvent) {

    }

    @FXML
    fun temaClaroMenu(event: ActionEvent) {

    }

    @FXML
    fun temaOscuroMenu(event: ActionEvent) {

    }

    @FXML
    fun temaSelvaticoMenu(event: ActionEvent) {

    }

    @FXML
    fun clickOnTable(event: MouseEvent) {
        if (this.tableTableroJuego.selectionModel.selectedIndex != -1) {
            val posSeleccionada: String = java.lang.String.valueOf(this.tableTableroJuego.selectionModel.selectedIndex)
            val celdaSeleccionada = this.tableTableroJuego.selectionModel.selectedCells.firstOrNull()
            if (celdaSeleccionada != null) {
                val filSeleccionada = celdaSeleccionada.row
                val colSeleccionada = celdaSeleccionada.column
                posicionClick[0] = filSeleccionada
                posicionClick[1] = colSeleccionada
                val celda = this.tableTableroJuego.getVisibleLeafColumn(colSeleccionada).getCellObservableValue(filSeleccionada).value
                val valorCelda = celda?.toString()
                println("Valor de la celda seleccionada: $valorCelda")
                println(Arrays.toString(posicionClick))
            }
        }
    }

    fun posicionarPrimerElemento(){
        partida.mapa.setPosicion(9,4,allElementos.pop()!!)
    }

    fun actualizarTabla(){
        tableTableroJuego.items.clear()
        for (i in 0..partida.mapa.getFilas() - 1) {

            val fila = Fila(
                partida.mapa.getPosicion(i, 0)?.toString() ?: "",
                partida.mapa.getPosicion(i, 1)?.toString() ?: "",
                partida.mapa.getPosicion(i, 2)?.toString() ?: "",
                partida.mapa.getPosicion(i, 3)?.toString() ?: "",
                partida.mapa.getPosicion(i, 4)?.toString() ?: "",
                partida.mapa.getPosicion(i, 5)?.toString() ?: "",
                partida.mapa.getPosicion(i, 6)?.toString() ?: "",
                partida.mapa.getPosicion(i, 7)?.toString() ?: "",
                partida.mapa.getPosicion(i, 8)?.toString() ?: ""
            )
            tableTableroJuego.items.add(fila)
        }
    }

    fun movimientoIzquierda(){
        println("capturado movimiento izquierda")
        direccion = 1

        try {
            var elementoAux: Any? = null

            if(colAct-1 >= 0){
                if(partida.mapa.getPosicion(filAct,colAct-1) == null){
                    partida.mapa.setPosicion(filAct,colAct-1,partida.mapa.getPosicion(filAct,colAct)!!)
                }
            }

            if (colAct+1 <= partida.mapa.getColumnas()){
                if (partida.mapa.getPosicion(filAct,colAct+1) != null){
                    elementoAux = partida.mapa.getPosicion(filAct,colAct+1)
                    println(elementoAux)
                    partida.mapa.setPosicion(filAct,colAct,elementoAux!!)
                }else{
                    partida.mapa.setPosicion(filAct,colAct,null)
                }
            }

            colAct = colAct-1
            actualizarTabla()
        }catch (e:Exception){
            Datos.gestionErrores(e,"movimientoIzquierda")
        }
    }
    fun movimientoDerecha(){
        direccion = 2

        println("capturado movimiento dercha")
        try {
            var elementoAux: Any? = null

            if(colAct+1 <= partida.mapa.getColumnas()){
                if(partida.mapa.getPosicion(filAct,colAct+1) == null){
                    partida.mapa.setPosicion(filAct,colAct+1,partida.mapa.getPosicion(filAct,colAct)!!)
                }
            }

            if (colAct-1 >= 0){
                if (partida.mapa.getPosicion(filAct,colAct-1) != null){
                    elementoAux = partida.mapa.getPosicion(filAct,colAct-1)
                    println(elementoAux)
                    partida.mapa.setPosicion(filAct,colAct,elementoAux!!)
                }else{
                    partida.mapa.setPosicion(filAct,colAct,null)
                }
            }

            colAct = colAct+1
            actualizarTabla()
        }catch (e:Exception){
            Datos.gestionErrores(e,"movimientoIzquierda")
        }
    }
    fun movimientoArriba(){
        direccion = 3

        println("capturado movimiento arriba")
        try {
            var elementoAux: Any? = null

            if(filAct-1 >= 0){
                if(partida.mapa.getPosicion(filAct-1,colAct) == null){
                    partida.mapa.setPosicion(filAct-1,colAct,partida.mapa.getPosicion(filAct,colAct)!!)
                }
            }

            if (filAct+1 <= partida.mapa.getFilas()){
                if (partida.mapa.getPosicion(filAct+1,colAct) != null){
                    elementoAux = partida.mapa.getPosicion(filAct+1,colAct)
                    println(elementoAux)
                    partida.mapa.setPosicion(filAct,colAct,elementoAux!!)
                }else{
                    partida.mapa.setPosicion(filAct,colAct,null)
                }
            }

            filAct = filAct-1
            actualizarTabla()
        }catch (e:Exception){
            Datos.gestionErrores(e,"movimientoIzquierda")
        }
    }
    fun movimientoAbajo(){
        direccion = 4

        println("capturado movimiento abajo")
        try {
            var elementoAux: Any? = null

            if (filAct+1 <= partida.mapa.getFilas()){
                if(partida.mapa.getPosicion(filAct+1,colAct) == null){
                    partida.mapa.setPosicion(filAct+1,colAct,partida.mapa.getPosicion(filAct,colAct)!!)
                }
            }

            if(filAct-1 >= 0){
                if (partida.mapa.getPosicion(filAct-1,colAct) != null){
                    elementoAux = partida.mapa.getPosicion(filAct-1,colAct)
                    println(elementoAux)
                    partida.mapa.setPosicion(filAct,colAct,elementoAux!!)
                }else{
                    partida.mapa.setPosicion(filAct,colAct,null)
                }
            }

            filAct = filAct+1
            actualizarTabla()
        }catch (e:Exception){
            Datos.gestionErrores(e,"movimiento abajo")
        }
    }


}
