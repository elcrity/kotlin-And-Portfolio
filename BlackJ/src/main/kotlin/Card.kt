
//BlackJ - Card.Kt
data class Card(val suit: Suit, val rank: Rank){
    override fun toString(): String {
        return "$suit$rank"
    }
}

enum class Rank(val value: Int) {
    ACE(1), TWO(2), THREE(3),
    FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9),
    TEN(10), JACK(10), QUEEN(10), KING(10);

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

enum class Suit(val symbol: String) {
    CLUBS("♣"),
    DIAMONDS("♦"),
    HEARTS("♥"),
    SPADES("♠");

    override fun toString(): String {
        return symbol
    }
}