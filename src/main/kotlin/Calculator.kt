import javafx.fxml.FXML
import javafx.scene.Parent
import javafx.scene.layout.VBox
import tornadofx.*;
import javafx.scene.control.Label
import javafx.scene.input.KeyEvent

import Operator.*
import javafx.scene.control.Button

class Calculator  : View(){

    override val root: VBox by fxml()

    @FXML
    lateinit var display : Label

    /*
        This init-block is useful to get the objects needed from our .fmxl document
     */
    init {
        title = "Kotlin Calculator"

        // Here, we go an iterate through each button in our .fxml file and give them an onClick listener
        root.lookupAll("button").forEach{b ->
            b.setOnMouseClicked {
                operator((b as Button).text)
            }
        }

        root.addEventFilter(KeyEvent.KEY_TYPED) {
            operator(it.character.toUpperCase().replace("\r", "="))
        }
    }

    var state : Operator = add(0)

    fun onAction(fn: Operator){
        state = fn
        display.text = ""
    }

    val displayValue : Long
        get() = when(display.text){
            "" -> 0
            else -> display.text.toLong()
        }

    private fun operator(x: String){
        if (Regex("[0-9]").matches(x)){
            display.text += x
        }else{
            when(x){
                "+" -> onAction(add(displayValue))
                "-" -> onAction(sub(displayValue))
                "/" -> onAction(div(displayValue))
                "%" -> { onAction(add(displayValue /100)); operator("=") }
                "X" -> onAction(mult(displayValue))
                "C" -> onAction(add(0))
                "+/-" -> { onAction(add(-1* displayValue)); operator("=") }
                "=" -> display.text = state.calculate(displayValue).toString()
            }
        }
    }
}