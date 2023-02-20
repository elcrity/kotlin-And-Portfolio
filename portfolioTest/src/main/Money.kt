package main

fun winPrize(player: Player, cost:Int, isBJ : Boolean){
    player.deck.add(Deck())
    when (player.pName) {
        "무승부" -> println("무승부입니다.")
        else -> when(isBJ) {
            true -> player.Budjet += cost * 2 + cost/2
            false -> player.Budjet += cost * 2
        }
    }
    println("승자는 " + player.pName)
}

fun betMoney(player:Player,cost:Int,isBJ : Boolean) {
    when(isBJ) {
        true -> player.Budjet -= (cost + cost/2)
        false -> player.Budjet -= cost
    }
}

