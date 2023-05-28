package Auxiliar

import javafx.scene.control.Alert
import javafx.scene.control.ButtonType

object Mensaje {

    fun informativo(cabecera: String){
        var alerta = Alert(Alert.AlertType.INFORMATION)
        alerta.title = "Lea detenidamente"
        alerta.headerText = cabecera
        alerta.contentText = "Pulse para continuar"

        alerta.buttonTypes.remove(ButtonType.CANCEL)

        alerta.showAndWait()
    }
    fun alerta(cabecera:String):ButtonType{
        var alerta = Alert(Alert.AlertType.WARNING)
        alerta.title = "Atención!"
        alerta.headerText = cabecera
        alerta.contentText = "Esta es una acción irreversible."

        alerta.buttonTypes.remove(ButtonType.OK)
        alerta.buttonTypes.remove(ButtonType.CANCEL)

        alerta.buttonTypes.add(ButtonType.YES)
        alerta.buttonTypes.add(ButtonType.NO)

        return alerta.showAndWait().orElse(ButtonType.YES)
    }








}