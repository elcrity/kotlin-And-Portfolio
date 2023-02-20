package test

fun drawCardT(dstn :tDeck, start:tDeck, aceNum : ArrayList<Int>){//A카드 자리수 체크,
    dstn.Card.add(start.Card[0])
    dstn.Scr += start.Card[0].value
    start.Card.removeAt(0)
    when (dstn.Card[dstn.Card.size-1].name) {
        "A" -> aceNum.add(dstn.Card.size-1)
    }
}

//fun drawStartT(player: Player, dealer :Player, deck :Player,  aceNum : ArrayList<Int>){
//    for (i in 0..1) {//기본패
//        drawCardT(player.deck[0],deck.deck[0],aceNum)
//        delay(200)
//        println("뽑은 카드는 " + player.deck[0].Card[player.deck[0].Card.size-1].pattern + player.deck[0].Card[player.deck[0].Card.size-1].name + "입니다" )
//        drawCardT(dealer.deck[0],deck.deck[0],aceNum)
//    }
//    delay(200)
//    showCardAndScore(player)
//
//    delay(300)
//
//    println()
//    println(dealer.pName +" ")
//    showCard(dealer.deck[0].Card, 0)
//    println("뒷면")
//    println()
//}

fun showHandCardT(player:ArrayList<tDeck>){
    println(player[0].Card.size)
    println(player[0].pName + "의 현재 패는 ")
    for(i in 0 until player[0].Card.size) {
        print(player[0].Card[i].pattern + " " + player[0].Card[i].name)
        when(i) {
            player[0].Card.size-1 -> continue
            else -> print(" / ")
        }
    }
    println()
}

fun makePlayerT(name: String, cost: Int = 100) = when(name){
    "dealer" -> tDeck("딜러",500)
    else -> ArrayList(arrayListOf<tDeck>().plus(tDeck(name,cost)))
}