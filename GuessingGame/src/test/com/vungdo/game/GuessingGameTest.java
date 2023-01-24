package com.vungdo.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {
    @Test
    public void testSimpleWinSituation(){
        GuessingGame game = new GuessingGame();
        int randomNum = game.getLastRandomNumber();
        String message = game.guess(3);
        assertEquals("You win!", message);
    }
    @Test
    public void testOneWrongSituation(){
        GuessingGame game = new GuessingGame();
        int randomNum = game.getLastRandomNumber();
        String message = game.guess(-5);
        assertEquals("You didn't got it!", message);
    }
}
