package sample;

import java.util.*;

public class Game {

    private static final String[] colors = {"Blue", "Green", "Orange", "Purple", "Red", "Yellow"};
    private List<Integer> col = new ArrayList<>();

    /**
     * Method hiddenCode() returns a random List of 4 Strings being the hidden answer
     * @return
     */

    public List<String> hiddenCode() {

        List<String> ht = new ArrayList<>();

        if (col.isEmpty()) {
            for (int i = 0; i < colors.length; i++) {
                col.add(i);
            }
        }

        Collections.shuffle(col);

        for (int i = 0; i < 4; i++) {
            ht.add(colors[col.get(i)]);
        }
        return ht;
    }

    /**
     * Method cypher converts a List of colors in String to List of colors coded in Integers
     * @param k
     * @return
     */

    public List<Integer> cypher(List<String> k) {
        List<Integer> codeInInts = new ArrayList<>();
        for (int i = 0; i < k.size(); i++) {
            switch (k.get(i)) {
                case "Blue": {
                    codeInInts.add(0);
                    break;
                }
                case "Green": {
                    codeInInts.add(1);
                    break;
                }
                case "Orange": {
                    codeInInts.add(2);
                    break;
                }
                case "Purple": {
                    codeInInts.add(3);
                    break;
                }
                case "Red": {
                    codeInInts.add(4);
                    break;
                }
                case "Yellow": {
                    codeInInts.add(5);
                    break;
                }
            }
        }
        return codeInInts;
    }

    /**
     * Method decypher converts List of Integers to appropriately signed Strings in a List
     * @param guess
     * @return
     */

    public List<String> decypher(List<Integer> guess) {
        List<String> dec = new ArrayList<>();

        for (int i = 0; i < guess.size(); i++) {
            switch (guess.get(i)) {
                case 0:
                    dec.add("Blue");
                    break;
                case 1:
                    dec.add("Green");
                    break;
                case 2:
                    dec.add("Orange");
                    break;
                case 3:
                    dec.add("Purple");
                    break;
                case 4:
                    dec.add("Red");
                    break;
                case 5:
                    dec.add("Yellow");
                    break;
            }
        }
        return dec;
    }

    /**
     * Method initialGuess returns the List of Strings which is the first guess done
     * @return
     */

    public List<String> initialGuess() {

        List<String> init = new ArrayList<>(4);
        if(!col.isEmpty()) {
            Collections.shuffle(col);

            for (int i = 0; i < 4; i++) {
                init.add(colors[col.get(i)]);
            }
        }
            return init;
    }

    /**
     * Method allSolutions returns a List of all possible codes that are contained in separate Lists
     * @return
     */

    public List<List> allSolutions()
    {
        List<List> tokens = new ArrayList<>();
        for (int d1 = 0; d1 < colors.length; d1++)
            for (int d2 = 0; d2 < colors.length; d2++)
                for (int d3 = 0; d3 < colors.length; d3++)
                    for (int d4 = 0; d4 < colors.length; d4++)
                    {
                        if (d1 != d2 && d1 != d3 && d1 != d4 && d2 != d3 && d2 != d4 && d3 != d4)
                        {
                            List<Integer> k = new ArrayList<>();
                            k.add(d1);
                            k.add(d2);
                            k.add(d3);
                            k.add(d4);
                            tokens.add(k);
                        }
                    }
        return tokens;
    }




}
