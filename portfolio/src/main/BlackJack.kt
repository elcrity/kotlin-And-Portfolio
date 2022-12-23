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

        drawStart(handCard1, dealerHand, deck)

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

        delay()

        while(!handCard1.isBJ) {
            dealerAce(dealerHand,handCard1)
            when(drawDealer(dealerHand, deck)){
                true -> continue
                false -> break
            }
        }

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

/*
            for (i in 0..deck.size - 1) {//덱 생성 확인용
                print(deck[i].name + " ")
                print(deck[i].pattern + " ")
                println(deck[i].value)
            }
*/

    }
    println("승자는 " + winner.pName)
}