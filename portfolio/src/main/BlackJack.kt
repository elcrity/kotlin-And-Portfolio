package Port.Test

import Port.randomDice


fun BlackJack() {
    //게임 시작시 덱, 플레이어 생성
    var deck = SetDeck()
    var dealerHand = MakePlayer("딜러")
    var handCard1 = MakePlayer("1번")

    //라운드 체크
    var round = 1
    round = inputCheck()

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
        deck.shuffle()
        for (i in 0..1) {//기본패
            handCard1.card.add(DrawCard(deck))
            ShowHandCard(handCard1.Player, handCard1.card, i)
            dealerHand.card.add(DrawCard(deck))
            ShowHandCard(dealerHand.Player, dealerHand.card, i)
        }


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