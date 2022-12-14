package BlackJack


fun BlackJack() {
    //게임 시작시 덱, 플레이어 생성
    //라운드 체크
    println("몇라운드로 게임을 시작할까요?")
    val round = inputCheck()

    for (i in 1..round) {//게임실행 본문
        val deck = SetDeck()
        val dealerHand = MakePlayer("딜러")
        val handCard1 = MakePlayer("1번")

        deck.Card.shuffle()

        DrawStart(handCard1,dealerHand,deck)

//블랙잭 테스트용
//        var testCard1 = Card("A","*",1)
//        var testCard2 = Card("10","*",10)
//        handCard1.Card.add(testCard1)
//        handCard1.Scr += handCard1.Card[0].value
//        handCard1.Card.add(testCard2)
//        handCard1.Scr += handCard1.Card[1].value

        println()
    while(true) {
        yesAce(handCard1)
        when (handCard1.Scr) {
            in 0..20 -> {
                println(
                    """추가로 드로우 하시겠습니까?
                        |1. 드로우
                        |2. 스탑
                    """.trimMargin()
                )
                var input = inputCheck()
                when (input) {
                    1 -> {
                        DrawCard(handCard1,deck)
                        ShowHandCard(handCard1)
                    }
                    2 -> break
                }
            }
            21 -> {
                if(handCard1.Card.size == 2) {
                    println("블랙잭")
                } else {
                    println("21")
                }
                break
            }
            in 21..40 -> {
                println("버스트")
                break
            }
        }

    }
        println("끝")


//    for(i in 0..handCard1.size-1) {//패 확인
//        print("1손패 = " + handCard1[i].name + " ")
//        print(handCard1[i].value)
//        println(" " + handCard1[i].pattern)
//        print("딜러 손패 = " + dealerHand[i].name + " ")
//        print(dealerHand[i].value)
//        println(" " + dealerHand[i].pattern)
//    }

//            for (i in 0..deck.size - 1) {//덱 생성 확인용
//                print(deck[i].name + " ")
//                print(deck[i].pattern + " ")
//                println(deck[i].value)
//            }
//        }

    }
}