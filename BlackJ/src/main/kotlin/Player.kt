class Player(private val name: String) {
    private val cards: MutableList<Card> = mutableListOf()
    private var score : Int = 0


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

