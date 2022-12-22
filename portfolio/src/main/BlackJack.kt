package main

fun blackJack() {
    //게임 시작시 덱, 플레이어 생성
    //라운드 체크
    var winner :Deck
    val dealerHand = makePlayer("딜러",500)
    val handCard1 = makePlayer("1번 플레이어")
    val deck = setDeck()
    
    while(true) {//게임실행 본문

        var investment = costCheck(handCard1,dealerHand)

        deck.Card.shuffle()
        println("현재 카드 덱의 숫자는 " + deck.Card.size +"입니다.")

        DrawStart(handCard1, dealerHand, deck)

/*블랙잭 테스트용
        var testCard1 = Card("A","*",1)
        var testCard2 = Card("10","*",10)
        handCard1.Card.add(testCard1)
        handCard1.Scr += handCard1.Card[0].value
        handCard1.Card.add(testCard2)
        handCard1.Scr += handCard1.Card[1].value*/
        do{
            when{
               handCard1.Scr != -1 -> yesAce(handCard1)
            }
            val b: Boolean = drawPlayer(handCard1,deck)
        }while(b)
        println()
/*       while (true) {
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
                            DrawCard(handCard1, deck)
                            ShowHandCard(handCard1)
                        }
                        2 -> break
                    }
                }
                21 -> {
                    if (handCard1.Card.size == 2) {
                        println("블랙잭")
                    } else {
                        println("21")
                    }
                    break
                }
                else -> {
                    println(handCard1.pName +" 버스트")
                    handCard1.Scr = -1
                    break
                }
            }

        }*/
        delay()

        while(!handCard1.isBJ) {
            dealerAce(dealerHand,handCard1)
            when(drawDealer(dealerHand, deck)){
                true -> continue
                false -> break
            }
        }
/*        while(handCard1.Scr != -1){//딜러 드로우 시키기
            when (dealerHand.Scr) {
                in 0..16 -> {
                    println(dealerHand.pName +"의 점수는 16점 이하 - 드로우")
                    DrawCard(dealerHand, deck)
                    ShowHandCard(dealerHand)//한장 가리고 드로우하는걸로 바꾸기
                }
                in 17..20 -> {
                    println(dealerHand.pName +"의 점수는 17점 이상 - 스탑")
                    break
                }
                21 -> {
                    println(dealerHand.pName +"의 점수는 21점")
                    if (handCard1.Card.size == 2) {
                        println("블랙잭")
                    } else {
                        println("21")
                    }
                    break
                }
                else -> {
                    dealerHand.Scr = -1
                    println(dealerHand.pName +" 버스트")
                    break
                }
            }
    }*/

        if(handCard1.isBJ || dealerHand.isBJ) investment += investment/2
        winner = whoWinner(handCard1,dealerHand)

        delay()
        println()
        println("점수를 확인합니다.")
        println()

        showScore(handCard1)
        showScore(dealerHand)

        println()
        if(winner.pName != "무승부") {
            betMoney(dealerHand, investment, handCard1.isBJ)
            betMoney(handCard1, investment, dealerHand.isBJ)
        }

//        println("승자는 " + winner.pName + " 획득한 금액은 " + investment + "원 입니다.")

        winPrize(winner, investment,handCard1.isBJ || dealerHand.isBJ)
        println(" 획득한 금액은 " + investment + "원 입니다.")

        println(handCard1.pName + "의 총 잔액은 " + handCard1.Budjet)
        println(dealerHand.pName + "의 총 잔액은 " + dealerHand.Budjet)

        resetDeck(handCard1,dealerHand,deck)

        if(handCard1.Budjet == 0 || dealerHand.Budjet == 0)
            break
        println()
        println("그만 하시려면 exit, 계속 하시려면 아무 글자 입력")
        if(readLine().equals("exit",true)){
            break
        }else
            continue
/*    for(i in 0..handCard1.size-1) {//패 확인
        print("1손패 = " + handCard1[i].name + " ")
        print(handCard1[i].value)
        println(" " + handCard1[i].pattern)
        print("딜러 손패 = " + dealerHand[i].name + " ")
        print(dealerHand[i].value)
        println(" " + dealerHand[i].pattern)
    }

            for (i in 0..deck.size - 1) {//덱 생성 확인용
                print(deck[i].name + " ")
                print(deck[i].pattern + " ")
                println(deck[i].value)
            }
        }*/
    }
    println("승자는 " + winner.pName)
}