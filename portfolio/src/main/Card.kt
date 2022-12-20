package BlackJack

class Card(
    var name :String = "미정",
    var pattern :String = "모름", //스페이드, 다이아, 하트, 클로버
    var value : Int = -1
)


fun ShowCard(Card:ArrayList<Card>, i:Int){
    print(Card[i].pattern)
    print(Card[i].name +" ")
//    print(" " + Card[i].value +" ")
}

fun ShowHandCard(deck:Deck){
    println(deck.pName + "의 현재 패는 ")
    for(i in 0..deck.Card.size-1) {
        print(deck.Card[i].pattern + " ")
        println(deck.Card[i].name)
    }
    ShowScore(deck)
}

fun ShowScore(deck:Deck){
    when {
        deck.Scr >= 0 && deck.Scr <= 21 ->{
            print(deck.pName + "의 점수는 " + deck.Scr +"점 입니다")
            println ()
        }
        deck.Scr == -1 || deck.Scr>21->{
            print(deck.pName + "는 버스트 됐습니다.")
            println ()
        }

    }
}