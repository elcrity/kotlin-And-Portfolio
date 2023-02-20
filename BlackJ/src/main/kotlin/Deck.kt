class Deck {
    val cards = mutableListOf<Card>()

    init {
        for (suit in Suit.values()) {
            for (rank in Rank.values()) {
                cards.add(Card(suit, rank))
            }
        }
    }

    fun drawDeckCard(): Card? {
        if (cards.isEmpty()) {
            return null
        }
        return cards.removeAt(0)
    }
}