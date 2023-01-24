package com.vungdo.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @Test
    void getValueOfAce() {
        assertEquals(1, Rank.ACE.getValue());
    }
    @Test
    void getValueOfTwo() {
        assertEquals(2, Rank.TWO.getValue());
    }
    @Test
    void getValueOfThree() {
        assertEquals(3, Rank.THREE.getValue());
    }
    @Test
    void getValueOfKing() {
        assertEquals(10, Rank.KING.getValue());
    }

}