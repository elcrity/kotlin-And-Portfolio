enum class Suit(private val symbol: String) {
    CLUBS("♣"),
    DIAMONDS("♦"),
    HEARTS("♥"),
    SPADES("♠");

    override fun toString(): String {
        return symbol
    }
}