package BlackJack

/*
기존. 함수를 만들거나 카드 드로우 작동을 할때
player.Card.add(DrawCard(deck)) 일일히 전부 적어줘야했고
리턴값이 있어 편하게 사용하기 힘듬
*/
//fun DrawCard(deck :ArrayList<Card>): Card {//셔플과 함께 사용, 첫번째 카드 뽑음
//    var dCard = Card(deck[0].name,deck[0].pattern,deck[0].value)
//    deck.removeAt(0)
//    return dCard
//}


fun DrawCard(user :Deck, deck:Deck){//두번째, 함수 작성 자체는 Deck.Card.property가 되어 귀찮아졌지만 사용할때 편해짐
    user.Card.add(deck.Card[0])
    user.Scr += deck.Card[0].value
    deck.Card.removeAt(0)
}

fun DrawStart(player: Deck, dealer :Deck, deck :Deck){
    for (i in 0..1) {//기본패
        DrawCard(player,deck)
        DrawCard(dealer,deck)
    }
    print(player.pName +" ")
    ShowHandCard(player)

    println()
    println(dealer.pName +" ")
    ShowCard(dealer.Card, 0)
    println("뒷면")
    println()
}