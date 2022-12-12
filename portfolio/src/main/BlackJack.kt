package BlackJack


fun BlackJack() {
    //게임 시작시 덱, 플레이어 생성
    //라운드 체크
    var input = 0
    println("몇라운드로 게임을 시작할까요?")
    val round = inputCheck()

//    while(true) {
//        println("몇라운드로 게임을 시작할까요?")
//        val input = readLine()//숫자 입력
//
//        if(input.equals("")) {//숫자 미입력시 반복
//            println("숫자가 입력되지 않음. 확인해주세요")
//            continue
//        }
//        else
//            round = input!!.toInt()
//        break
//    }

    for (i in 1..round) {//게임실행 본문
        val deck = SetDeck()
        val dealerHand = MakePlayer("딜러")
        val handCard1 = MakePlayer("1번")

        deck.Card.shuffle()

        DrawStart(handCard1,dealerHand,deck)
        println()

    while(true) {
        when (handCard1.Scr) {
            in 0..20 -> {
                println(
                    """추가로 드로우 하시겠습니까?
                        |1. 드로우
                        |2. 스탑
                    """.trimMargin()
                )
                input = inputCheck()
                when (input) {
                    1 -> {
                        DrawCard(handCard1,deck)
                        ShowHandCard(handCard1)
                    }
                    2 -> break
                }
            }
            21 -> {
                println("21")
                break
            }
            in 21..40 -> {
                println("패배")
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