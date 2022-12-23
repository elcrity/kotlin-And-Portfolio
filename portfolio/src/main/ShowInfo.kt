package main

fun showCard(Card:ArrayList<Card>, i:Int){
    print(Card[i].pattern)
    print(Card[i].name +" ")
//    print(" " + Card[i].value +" ")
}

fun showHandCard(deck:Deck){
    println(deck.pName + "의 현재 패는 ")
    for(i in 0 until deck.Card.size) {
        print(deck.Card[i].pattern + " " + deck.Card[i].name)
        when(i) {
            deck.Card.size-1 -> continue
            else -> print(" / ")
        }
    }
    println()
}
fun showScore(deck:Deck){
    when {
        deck.Scr in 0..21 ->{
            delay()
            print(deck.pName + "의 점수는 " + deck.Scr +"점 입니다")
            println ()
        }
        deck.Scr == -1 || deck.Scr>21->{
            delay()
            print(deck.pName + "의 점수는 " + deck.Scr +"점 입니다")
            print(deck.pName + "는 버스트 됐습니다.")
            println ()
        }

    }
}

fun showCardAndScore(who : Deck){
    showHandCard(who)
    showScore(who)
}
