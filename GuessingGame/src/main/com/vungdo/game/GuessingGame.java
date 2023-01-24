package com.vungdo.game;

import java.util.ArrayList;
import java.util.List;

public class GuessingGame {
    public String guess(int guessedNumber) {
        return "You got it!";
    }

    public int getLastRandomNumber() {
        return 0;
    }

    public static void main(String[] args) {
        var list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        System.out.println(list);

    }
}
