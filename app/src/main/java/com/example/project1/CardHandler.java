package com.example.project1;

import java.util.Arrays;
import java.util.Random;

public class CardHandler {

    public String[] imageIDhard = {"ace_of_spades", "ace_of_spades2", "black_joker", "four_of_diamonds",
    "jack_of_hearts2", "jack_of_spades2", "king_of_clubs2", "king_of_diamonds2", "king_of_hearts2",
    "queen_of_clubs2", "queen_of_diamonds2", "queen_of_hearts2", "red_joker", "six_of_diamonds",
    "six_of_hearts", "ten_of_clubs", "three_of_hearts", "two_of_diamonds"};

    public String[] imageIDmedium = {"jack_of_hearts2", "jack_of_spades2", "king_of_clubs2",
            "king_of_diamonds2", "king_of_hearts2", "queen_of_clubs2",
            "queen_of_diamonds2", "queen_of_hearts2"};

    public String[] imageIDeasy = {"jack_of_hearts2", "jack_of_spades2"};

    //Creates an integer array and shuffles cards
    public int[] createShuffledArray (String Deck[]) {
        int LengthofArray = Deck.length;
        int DoubleSize = LengthofArray * 2;
        int[] ShuffledDeck = new int[DoubleSize];
        int independentCounter = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < LengthofArray; j++) {
                ShuffledDeck[independentCounter]=j;
                independentCounter=independentCounter+1;
            }
        }

        Random rand = new Random();
        for (int i = 0; i < ShuffledDeck.length; i++) {
            int randomIndexToSwap = rand.nextInt(ShuffledDeck.length);
            int temp = ShuffledDeck[randomIndexToSwap];
            ShuffledDeck[randomIndexToSwap] = ShuffledDeck[i];
            ShuffledDeck[i] = temp;
        }
        return ShuffledDeck;
    }

}
