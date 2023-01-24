package com.vungdo.blackjack;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Card card = new Card(Suit.HEARTS, Rank.TEN);
        var suites = Suit.values();
        System.out.println(suites[1]);
        System.out.println(card);
    }

    public int getValue() {
        return this.rank.getValue();
    }
}
