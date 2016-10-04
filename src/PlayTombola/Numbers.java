package PlayTombola;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Numbers {

    private final List<Integer> numberList;
    private final List<String> buttonList;
    private final Stack<Integer> previousNums = new Stack<>();

    public Numbers() {

        numberList = new LinkedList<>();
        buttonList = new LinkedList<>();

        for (int i = 1; i <= 90; ++i) {
            numberList.add(i);
            buttonList.add("num" + i);
        }
        previousNums.clear();
    }

    public int getNum(int randNum) {

        int number = numberList.get(randNum);
        numberList.remove(randNum);
        return number;
    }

    public int getSize() {

        if (numberList.isEmpty()) {
            return 100;
        } else {
            return numberList.size();
        }
    }

    public String getButton(int randNum) {

        String button = buttonList.remove(randNum);
        return button;
    }

    public void setPreviousNum(int n) {

        previousNums.push(n);
    }

    public int getPreviousNUm() {

        if (previousNums.isEmpty()) {
            return 100;
        } else {
            return previousNums.peek();
        }
    }

    //print numbers in file
    public void printLog() {

        Writer x;
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy. HH:mm"); //format for output
        Date date = new Date();

        try {
            x = new BufferedWriter(new FileWriter("numbers.txt"));
            x.append("\tTombola numbers\t" + format.format(date) + "h\n\n");
            for (Integer i : previousNums) {

                x.append(i.toString() + " ");
            }
            x.append("\n");
            x.append("\n");
            x.append("\n");
            x.append("\t\tDeveloped by Marko Batarelo");
            x.close();

            //System.out.println(previousNums.peek());
            System.out.println("printed");
        } catch (Exception ex) {
            System.out.println("Error writing to file");
        }

    }

    //reset all 
    public void reset() {

        buttonList.clear();
        numberList.clear();

        for (int i = 1; i <= 90; ++i) {
            numberList.add(i);
            buttonList.add("num" + i);
        }
        previousNums.clear();
    }
}
