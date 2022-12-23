package main

fun winPrize(deck: Player, cost:Int, isBJ : Boolean){
    deck.deck.add(Deck())
    when (deck.pName) {
        "무승부" -> println("무승부입니다.")
        else -> when(isBJ) {
            true -> deck.Budjet += cost * 2 + cost/2
            false -> deck.Budjet += cost * 2
        }
    }
    println("승자는 " + deck.pName)
}

fun betMoney(player:Player,cost:Int,isBJ : Boolean) {
    when(isBJ) {
        true -> player.Budjet -= (cost + cost/2)
        false -> player.Budjet -= cost
    }
}

