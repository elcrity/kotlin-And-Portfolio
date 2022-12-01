package Port.Test

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

fun DrawCard(deck :ArrayList<Card>): Card{//셔플과 함께 사용, 첫번째 카드 뽑음
    var dCard = Card(deck[0].name,deck[0].pattern,deck[0].value)
    deck.removeAt(0)
    return dCard
}

fun ShowHandCard(name:String, Card:ArrayList<Card>, i:Int){
    print(name + " " + Card[i].name + " ")
    print(Card[i].pattern)
    println(" " + Card[i].value)
}