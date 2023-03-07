package com.example.blackjack

import Card

class Deck{
    val cards : ArrayList<Card> = ArrayList()//플레이어가 가지고 있는 덱

    init {
        for (suit in Suit.values()) {
            for (rank in Rank.values()) {
                cards.add(Card(suit, rank))
            }
        }
        cards.shuffle()
    }

}