import java.util.*

fun main() {
    val deck = Deck()
    deck.cards.shuffle()

    val playerCards = Player("p1")
    val dealerCards = Player("딜러")

    // 플레이어가 카드 2장을 뽑음
    repeat(2) {
        playerCards.drawCard(deck)
    }
    // 딜러가 카드 2장을 뽑음
    repeat(2) {
        dealerCards.drawCard(deck)
    }


        playerCards.showCards()
        playerCards.showScore()
        dealerCards.showCards(false)
    // 플레이어가 카드를 계속 뽑거나 그만둘 때까지 반복
    while (true) {
        println("카드를 더 받으시겠습니까? (Y/N)")
        val input = readLine()?.uppercase(Locale.getDefault())
        if (input == "Y") {
            println("드로우한 카드는 ${deck.cards[0]}")
            playerCards.drawCard(deck)
            playerCards.showCards()
            playerCards.showScore()
            if (playerCards.getScore() > 21) {
                println("21점을 초과했습니다. 딜러의 승리입니다.")
                return
            }
        } else {
            break
        }
    }

    // 딜러가 17점 이상이 될 때까지 카드를 계속 뽑음
    while (dealerCards.getScore() < 16) {
        println("드로우한 카드는 ${deck.cards[0]}")
        dealerCards.drawCard(deck)
        dealerCards.showScore()
        dealerCards.showCards()
        if (dealerCards.getScore() > 21) {
            println("딜러가 21점을 초과했습니다. 플레이어의 승리입니다.")
            return
        }
    }

    val playerValue = playerCards.getScore()
    val dealerValue = dealerCards.getScore()
    dealerCards.showCards()
    dealerCards.showScore()
    when {
        playerValue > dealerValue -> println("플레이어의 승리입니다.")
        dealerValue > playerValue -> println("딜러의 승리입니다.")
        else -> println("무승부입니다.")
    }
}