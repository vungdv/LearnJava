package com.vungdo.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void canGetValueOfACard() {
        var card = new Card(Suit.CLUBS, Rank.ACE);
        assertEquals(1, card.getValue());
    }

    @Test
    void canGetValueOfAThreeCard() {
        var card = new Card(Suit.CLUBS, Rank.THREE);
        assertEquals(3, card.getValue());
    }
    @Test
    void canGetValueOfAJACKCard() {
        var card = new Card(Suit.CLUBS, Rank.JACK);
        assertEquals(10, card.getValue());
    }
}