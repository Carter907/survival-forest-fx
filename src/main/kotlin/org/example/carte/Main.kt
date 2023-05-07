package org.example.carte

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import java.nio.file.FileSystems
import java.nio.file.Files
import kotlin.io.path.toPath

class Main: Application() {

    override fun start(stage: Stage) {

        val loader = FXMLLoader(javaClass.getResource("/fxml/home.fxml"));

        val scene = Scene(loader.load());
        scene.stylesheets.add(javaClass.getResource("/css/game.css").toExternalForm())

        stage.title = "Survival Forest (FX)"
        stage.scene = scene;
        stage.show();
    }

}

fun main(args: Array<String>) {

    Application.launch(Main::class.java, *args)
}