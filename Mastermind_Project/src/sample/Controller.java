package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Controller {

    private Game game = new Game();
    private ThreadClass tc = new ThreadClass();

    @FXML
    private Circle c1Hidden;

    @FXML
    private Circle c2Hidden;

    @FXML
    private Circle c3Hidden;

    @FXML
    private Circle c4Hidden;

    @FXML
    private Circle c1Guess1;

    @FXML
    private Circle c2Guess1;

    @FXML
    private Circle c3Guess1;

    @FXML
    private Circle c4Guess1;

    @FXML
    private Circle c1Guess2;

    @FXML
    private Circle c2Guess2;

    @FXML
    private Circle c3Guess2;

    @FXML
    private Circle c4Guess2;

    @FXML
    private Circle c1Guess3;

    @FXML
    private Circle c2Guess3;

    @FXML
    private Circle c3Guess3;

    @FXML
    private Circle c4Guess3;

    @FXML
    private Circle c1Guess4;

    @FXML
    private Circle c2Guess4;

    @FXML
    private Circle c3Guess4;

    @FXML
    private Circle c4Guess4;

    @FXML
    private Circle c1Guess5;

    @FXML
    private Circle c2Guess5;

    @FXML
    private Circle c3Guess5;

    @FXML
    private Circle c4Guess5;


    @FXML
    private Button playBtn;

    @FXML
    private Circle c1Guess6;

    @FXML
    private Circle c2Guess6;

    @FXML
    private Circle c3Guess6;

    @FXML
    private Circle c4Guess6;

    @FXML
    private Text posGuess1;

    @FXML
    private Text posGuess2;

    @FXML
    private Text posGuess3;

    @FXML
    private Text posGuess4;

    @FXML
    private Text posGuess5;

    @FXML
    private Text posGuess6;

    @FXML
    private Text guess1Color;

    @FXML
    private Text guess2Color;

    @FXML
    private Text guess3Color;

    @FXML
    private Text guess4Color;

    @FXML
    private Text guess5Color;

    @FXML
    private Text guess6Color;

    @FXML
    private Button resetBtn;

    @FXML
    private HBox guessBox3;

    @FXML
    private HBox guessBox1;

    @FXML
    private HBox guessBox2;

    @FXML
    private HBox guessBox4;

    @FXML
    private HBox guessBox5;

    @FXML
    private HBox guessBox6;

    @FXML
    private VBox colorNumBox;

    @FXML
    private VBox positionBox;


    /**
     * The method playGame is an onAction method for Play button
     * Sets the colors in the initial spot for the answer as well as the first guess row
     * Initializes values using setters from ThreadClass
     * Then runs the Thread defined in the method which with each iteration evokes ThreadClass.kek method
     * Platform.runLater provides coloring of appropriate rows with switch case function
     * @param event
     */
    @FXML
    void playGame(ActionEvent event) {
        final int[] counter = {0};
        AtomicBoolean isRunning = new AtomicBoolean(true);

        List<String> hidden = game.hiddenCode();
        List<String> initGuess = game.initialGuess();

        c1Hidden.setFill(Paint.valueOf(hidden.get(0)));
        c2Hidden.setFill(Paint.valueOf(hidden.get(1)));
        c3Hidden.setFill(Paint.valueOf(hidden.get(2)));
        c4Hidden.setFill(Paint.valueOf(hidden.get(3)));

        c1Guess1.setFill(Paint.valueOf(initGuess.get(0)));
        c2Guess1.setFill(Paint.valueOf(initGuess.get(1)));
        c3Guess1.setFill(Paint.valueOf(initGuess.get(2)));
        c4Guess1.setFill(Paint.valueOf(initGuess.get(3)));


        tc.setGuess(game.cypher(initGuess));
        tc.setAnswer(game.cypher(hidden));
        tc.setAllSolutions(game.allSolutions());
        posGuess1.setText(String.valueOf(tc.getPositionPinValues(game.cypher(hidden),tc.getGuess())));
        guess1Color.setText(String.valueOf(tc.getColorPinValues(game.cypher(hidden),tc.getGuess())));

        Thread t = new Thread(() -> {

            while (isRunning.get()) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tc.kek();
                Platform.runLater(() -> {
                     counter[0]++;
                    if (tc.getGuess().equals(game.cypher(hidden))) {
                        isRunning.set(false);
                        System.out.println("Thou wonneth");
                    }else if(counter[counter.length-1]==5){
                        isRunning.set(false);
                        System.out.println("Thou losteth");
                    }
                    switch(counter[counter.length-1]){
                        case 1:{
                            c1Guess2.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(0)));
                            c2Guess2.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(1)));
                            c3Guess2.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(2)));
                            c4Guess2.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(3)));
                            posGuess2.setText(String.valueOf(tc.getPositionPinValues(game.cypher(hidden),tc.getGuess())));
                            guess2Color.setText(String.valueOf(tc.getColorPinValues(game.cypher(hidden),tc.getGuess())));
                            break;

                        }
                        case 2:{
                            c1Guess3.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(0)));
                            c2Guess3.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(1)));
                            c3Guess3.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(2)));
                            c4Guess3.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(3)));
                            posGuess3.setText(String.valueOf(tc.getPositionPinValues(game.cypher(hidden),tc.getGuess())));
                            guess3Color.setText(String.valueOf(tc.getColorPinValues(game.cypher(hidden),tc.getGuess())));
                            break;

                        }
                        case 3:{
                            c1Guess4.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(0)));
                            c2Guess4.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(1)));
                            c3Guess4.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(2)));
                            c4Guess4.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(3)));
                            posGuess4.setText(String.valueOf(tc.getPositionPinValues(game.cypher(hidden),tc.getGuess())));
                            guess4Color.setText(String.valueOf(tc.getColorPinValues(game.cypher(hidden),tc.getGuess())));
                            break;

                        }
                        case 4:{
                            c1Guess5.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(0)));
                            c2Guess5.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(1)));
                            c3Guess5.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(2)));
                            c4Guess5.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(3)));
                            posGuess5.setText(String.valueOf(tc.getPositionPinValues(game.cypher(hidden),tc.getGuess())));
                            guess5Color.setText(String.valueOf(tc.getColorPinValues(game.cypher(hidden),tc.getGuess())));
                            break;

                        }
                        case 5:{
                            c1Guess6.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(0)));
                            c2Guess6.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(1)));
                            c3Guess6.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(2)));
                            c4Guess6.setFill(Paint.valueOf(game.decypher(tc.getGuess()).get(3)));
                            posGuess6.setText(String.valueOf(tc.getPositionPinValues(game.cypher(hidden),tc.getGuess())));
                            guess6Color.setText(String.valueOf(tc.getColorPinValues(game.cypher(hidden),tc.getGuess())));
                            break;

                        }

                    }
                });
            }

        });
        t.start();

    }

}
