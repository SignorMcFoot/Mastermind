package sample;

import java.util.*;

public class ThreadClass {

    private List<Integer> guess;
    private List<Integer> answer;
    private List<List> allSolutions;
    private int checkColors = 0;
    private int checkPosition = 0;



    /**
     *  All generic Setters and Getters used in other parts of the code
     *
     */

    public void setAllSolutions(List<List> allSolutions) {
        this.allSolutions = allSolutions;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public List<Integer> getGuess() {
        return guess;
    }

    public void setGuess(List<Integer> guess) {
        this.guess = guess;
    }

    /**
     * The method called from the thread allows to change and set the guess
     */

    public void kek() {
        System.out.println("answer" + answer);
            checkColors = getColorPinValues(answer, guess);
            checkPosition = getPositionPinValues(answer,guess);
            change(checkColors, checkPosition);

        }

    /**
     * A method containing solving algorithm
     * It removes answers meeting certain criteria from the pool of remaining ones
     * First it checks for the color, then for position
     * @param checkColorList
     * @param checkPositionList
     */

    public void change(int checkColorList, int checkPositionList) {
        if (checkColorList != 4) {
            for (int i = 0; i < allSolutions.size(); i++) {
                if (getColorPinValues(answer, allSolutions.get(i)) != 4 || allSolutions.get(i).containsAll(guess)) {
                    allSolutions.remove(i);
                }
            }
            allSolutions.remove(guess);
        }

        if (getColorPinValues(answer, guess) == 4 && getPositionPinValues(answer, guess) != 4) {
            for (int i = 0; i < allSolutions.size(); i++) {
                if (!allSolutions.get(i).containsAll(guess)) {
                    allSolutions.remove(i);
                }
            }
            allSolutions.remove(guess);
            System.out.println("what have u done " + allSolutions.size());
        }


        if (getColorPinValues(answer, guess) == 4 && checkPositionList != 4) {
            System.out.println("Weszło tu ");
            while (allSolutions.size() > 1) {
                for (int i = 0; i < allSolutions.size(); i++) {
                    if (getPositionPinValues(answer, allSolutions.get(i)) != 4) {
                        allSolutions.remove(i);
                    }
                }
                allSolutions.remove(guess);
            }
        }
        Collections.shuffle(allSolutions);
        guess = allSolutions.get(0);
        System.out.println(guess + "Current");
        System.out.println(allSolutions.size() + "Current size");

    }

    /**
     * The method comparing guess to the answer in the color domain and returning the integer which is the amount of correct ones
     * @param answer
     * @param guess
     * @return
     */

    public int getColorPinValues(List<Integer> answer, List<Integer> guess) {

        int colorPins = 0;
        for (int i = 0; i < 4; i++) {
            if (answer.contains(guess.get(i))) {
                colorPins++;
            }
        }
        return colorPins;
    }

    /**
     * The method comparing guess to the answer in the position domain and returning the integer which is the amount of correct ones
     * @param answer
     * @param guess
     * @return
     */

    public int getPositionPinValues(List<Integer> answer, List<Integer> guess) {

        int posPins = 0;
        for (int i = 0; i < 4; i++) {
            if (answer.get(i) == (guess.get(i))) {
                posPins++;
            }
        }
        return posPins;
    }

}
