import javafx.stage.Stage
import tornadofx.*

class Application : App() {
    override val primaryView = Calculator::class

    // We override the start function to launch the application
    override fun start(stage: Stage) {
        importStylesheet("/style.css")
        stage.isResizable = false
        super.start(stage)
    }
}