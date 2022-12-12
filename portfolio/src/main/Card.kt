package BlackJack

class Card(
    var name :String = "미정",
    var pattern :String = "모름", //스페이드, 다이아, 하트, 클로버
    var value : Int = -1
)

//fun DrawCard(deck :ArrayList<Card>, num:Int): Card{//랜덤 숫자를 뽑아서 패산중 한장 뽑음
//    var dCard = Card()
//    dCard = deck[num]
//    deck.removeAt(num)
//
//    return dCard
//}


fun ShowCard(Card:ArrayList<Card>, i:Int){
    print(Card[i].pattern)
    print(Card[i].name +" ")
//    print(" " + Card[i].value +" ")
}

fun ShowHandCard(deck:Deck){
    println("내 현재 패는 ")
    for(i in 0..deck.Card.size-1) {
        print(deck.Card[i].pattern + " ")
        println(deck.Card[i].name)
    }
    print("내 점수는 " + deck.Scr)
    println(" 입니다.")
}