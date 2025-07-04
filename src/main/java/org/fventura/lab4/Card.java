/**
 * @author Franky
 * @date June 4th, 2025
 * Card class used for lab 4 part 2
 * Represents a single card using a number from 1 to 52.
 * This also contains a method to draw 4 random cards from a shuffled deck.
 */

package org.fventura.lab4;

import java.util.ArrayList;
import java.util.Collections;

public class Card {
    private final int number; // A number from 1 to 52 representing the card image

    // Constructor that sets the card number
    public Card(int number) {
        this.number = number;
    }
    // Returns the card's number
    public int getNumber() {
        return number;
    }

    // Returns the rank of the card (1–13)
    public int getRank() {
        return ((number - 1) % 13) + 1;
    }

    /**
     * Generates and returns 4 random cards from a 52 card deck
     * The deck is shuffled, and the first 4 cards are selected
     *
     * @return an ArrayList that contains 4 randomly picked Card objects
     */
    public static ArrayList<Card> drawCards() {
        ArrayList<Card> deck = new ArrayList<>();

        // This loop fills the deck with cards numbered 1 through 52
        for (int i = 1; i <= 52; i++) {
            deck.add(new Card(i));
        }

        // Randomly shuffles the deck
        Collections.shuffle(deck);

        // Picks the first 4 cards from the shuffled deck
        ArrayList<Card> pickedCards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            pickedCards.add(deck.get(i));
        }
        return pickedCards;
    }
}
