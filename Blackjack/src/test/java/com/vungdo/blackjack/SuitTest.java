package com.vungdo.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {
    @Test
    void heartPrintsHeartSymbol() {
        assertEquals("♥", Suit.HEARTS.toString());
    }
}