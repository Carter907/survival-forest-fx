package org.example.carte.controllers

import carte.toolfx.core.Controller
import javafx.animation.Animation.Status
import javafx.animation.TranslateTransition
import javafx.fxml.FXML
import javafx.scene.control.TextArea
import javafx.scene.input.MouseEvent
import javafx.scene.text.TextFlow
import javafx.util.Duration
import org.example.carte.animation.CommandConsoleAnimator
import java.net.URL
import java.util.*

class HomeController : Controller() {

    @FXML
    lateinit var commandConsole: TextArea

    @FXML
    lateinit var gameText: TextFlow

    private lateinit var commandConsoleAnimator: CommandConsoleAnimator;

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        setLater(gameText) {
        }
        commandConsoleAnimator = CommandConsoleAnimator();
        commandConsole.setOnMouseEntered(::onMouseEnteredCommandConsole)
        commandConsole.setOnMouseExited(::onMouseExitedCommandConsole)
    }

    private fun onMouseEnteredCommandConsole(mouseEvent: MouseEvent) {

        if (commandConsoleAnimator.isUp || commandConsoleAnimator.state == Status.RUNNING)
            return;
        val transition = TranslateTransition();
        transition.node = commandConsole;
        transition.fromX = commandConsole.translateX;
        transition.fromY = commandConsole.translateY;
        transition.toX = commandConsole.translateX;
        transition.toY = commandConsole.translateY-100;

        transition.cycleCount = 1;
        transition.duration = Duration.seconds(1.0);
        transition.play();
        transition.setOnFinished {
            commandConsoleAnimator.isUp = true;
            commandConsoleAnimator.state = Status.STOPPED;


        }


    }

    private fun onMouseExitedCommandConsole(mouseEvent: MouseEvent) {
        if (!commandConsoleAnimator.isUp || commandConsoleAnimator.state == Status.RUNNING)
            return;

        commandConsoleAnimator.state = Status.RUNNING;
        val transition = TranslateTransition();
        transition.node = commandConsole;
        transition.fromX = commandConsole.translateX;
        transition.fromY = commandConsole.translateY;
        transition.toX = commandConsole.translateX;
        transition.toY = 0.0;
        transition.delay = Duration.seconds(3.0);
        transition.cycleCount = 1;
        transition.duration = Duration.seconds(1.0);
        transition.play();
        transition.setOnFinished {
            commandConsoleAnimator.isUp = false;
            commandConsoleAnimator.state = Status.STOPPED;
        }
    }
}