package com.example.blackjack

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DeckViewModel : ViewModel() {

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score

    init{
        _score.value = 0
    }

}

data class Card(val suit: Suit, val rank: Rank){
    override fun toString(): String {
        return "$suit$rank"
    }
}

enum class Rank(val value: Int) {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    override fun toString(): String {
        return when (this) {
            ACE -> "A"
            JACK -> "J"
            QUEEN -> "Q"
            KING -> "K"
            else -> value.toString()
        }
    }
}

enum class Suit(private val symbol: String) {
    CLUBS("♣"),
    DIAMONDS("♦"),
    HEARTS("♥"),
    SPADES("♠");

    override fun toString(): String {
        return symbol
    }
}

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

class Player(private val name: String) {
    val cards: MutableList<Card> = mutableListOf()
    private var score : Int = 0

    fun hi(){
        println("하이")
    }

    fun drawCard(deck: Deck) : Boolean {
        var hasAce = false

        score += when (deck.cards[0].rank.value) {
            1 -> {
                hasAce = true
                1
            }
            else -> deck.cards[0].rank.value
        }

        if (hasAce && score + 10 <= 21) {
            score += 10
        }

        return cards.add(deck.cards.removeAt(0))
    }

    fun showCards(type :Boolean = true) {
        if (type) {
            println("${this.name}의 카드:")
            this.cards.forEach {
                println(" - $it")
            }
        } else {
            println(
                """${this.name}의 카드: 
                | - ${this.cards[0]} 
                | - 뒷면
            """.trimMargin()
            )
        }
    }

    fun showScore(){
        println("${this.name}의 점수는 ${this.score}")
    }

    fun getScore() = score
}
