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

fun DrawPlayer(player: Deck,deck: Deck) {
    while (true) {
        yesAce(player)
        when (player.Scr) {
            in 0..20 -> {
                println(
                    """추가로 드로우 하시겠습니까?
                            |1. 드로우
                            |2. 스탑
                        """.trimMargin()
                )
                val input = inputCheck()
                when (input) {
                    1 -> {
                        DrawCard(player, deck)
                        ShowHandCard(player)
                    }
                    2 -> break
                }
            }
            21 -> {
                if (player.Card.size == 2) {
                    println("블랙잭")
                    player.Scr = 100
                } else {
                    println("21")
                }
                break
            }
            else -> {
                player.Scr = -1
                break
            }
        }
    }
}

fun DrawDealer(dealer: Deck,player: Deck,deck : Deck){
    //딜러 드로우 시키기
    while(player.Scr != -1){//딜러 드로우 시키기
        when (dealer.Scr) {
            in 0..16 -> {
                println(dealer.pName +"의 점수는 16점 이하 - 드로우")
                DrawCard(dealer, deck)
                ShowHandCard(dealer)
            }
            in 17..20 -> {
                println(dealer.pName +"의 점수는 17점 이상 - 스탑")
                break
            }
            21 -> {
                println(dealer.pName +"의 점수는 21점")
                if (dealer.Card.size == 2) {
                    println("블랙잭")
                    player.Scr = 100
                } else {
                    println("21")
                }
                break
            }
            else -> {
                dealer.Scr = -1
                break
            }
        }
    }
}