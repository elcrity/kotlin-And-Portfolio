package main

fun winPrize(deck: Deck, cost:Int, isBJ : Boolean){
    when{
        deck.pName == "무승부" -> println("무승부입니다.")
        else -> when(isBJ) {
            true -> deck.Budjet += cost * 2 + cost/2
            false -> deck.Budjet += cost * 2
        }
    }
    print("승자는 " + deck.pName)
}

fun betMoney(player:Deck,cost:Int,isBJ : Boolean) {
    when(isBJ) {
        true -> player.Budjet -= (cost + cost/2)
        false -> player.Budjet -= cost
    }
}

fun whoWinner(player: Deck, dealer: Deck) :Deck{
   val winPlayer = when {
       player.Scr > dealer.Scr -> player
       player.Scr < dealer.Scr -> dealer
       (player.Card.size - 1) > (dealer.Card.size - 1) -> dealer
       (player.Card.size - 1) < (dealer.Card.size - 1) -> player
       else -> makePlayer("무승부", 0)
   }
    return winPlayer
}

