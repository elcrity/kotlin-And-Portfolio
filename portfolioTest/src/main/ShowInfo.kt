package main

fun showCard(Card:ArrayList<Card>, i:Int){
    print(Card[i].pattern)
    print(Card[i].name +" ")
//    print(" " + Card[i].value +" ")
}

fun showHandCard(player:Player){
    println(player.pName + "의 현재 패는 ")
    for(i in 0 until player.deck[0].Card.size) {
        print(player.deck[0].Card[i].pattern + " " + player.deck[0].Card[i].name)
        when(i) {
            player.deck[0].Card.size-1 -> continue
            else -> print(" / ")
        }
    }
    println()
}
fun showScore(player:Player){
    when {
        player.deck[0].Scr in 0..21 ->{
            delay()
            print(player.pName + "의 점수는 " + player.deck[0].Scr +"점 입니다")
            println ()
        }
        player.deck[0].Scr == -1 || player.deck[0].Scr>21->{
            delay()
            print(player.pName + "는 버스트 됐습니다.")
            println ()
        }

    }
}

fun showCardAndScore(who : Player){
    showHandCard(who)
    showScore(who)
}
