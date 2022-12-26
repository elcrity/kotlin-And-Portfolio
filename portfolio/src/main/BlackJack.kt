package main

fun blackJack() {
    //게임 시작시 덱, 플레이어 생성
    //라운드 체크
    var winner : Player
    val dealer = makePlayer("딜러",500)
    val player1 = makePlayer(inputCheckStr())
    val deck = setDeck()
    var split = 0
    
    while(true) {//게임실행 본문
        var investment = costCheck(player1,dealer)

        deck.deck[0].Card.shuffle()
        println("현재 카드 덱의 숫자는 " + deck.deck[0].Card.size +"입니다.")

        drawStart(player1, dealer, deck)

//스플릿 기능 제작중
        if(player1.deck[0].Card[0].name == player1.deck[0].Card[1].name){
            addPlayerDeck(player1)
            drawCard(player1.deck[1], player1.deck[0])
            drawCard(player1.deck[0], deck.deck[0])
            drawCard(player1.deck[1], deck.deck[0])
            split++
        }

/*블랙잭 테스트용
        var testCard1 = Card("A","*",1)
        var testCard2 = Card("10","*",10)
        handCard1.Card.add(testCard1)
        handCard1.Scr += handCard1.Card[0].value
        handCard1.Card.add(testCard2)
        handCard1.Scr += handCard1.Card[1].value
*/
        for(i in 0..split) {
            do {
                when {
                    player1.deck[0].Scr != -1 -> yesAce(player1)
                }
                val b: Boolean = drawPlayer(player1, deck, split)
            } while (b)
        }
        println()

        delay()

        while(true) {
            dealerAce(dealer,player1)
            if(!(player1.deck[0].isBJ && dealer.deck[0].Scr != 21))
            when(drawDealer(dealer, deck)){
                true -> continue
                false -> break
            }
        }

        if(player1.deck[0].isBJ || dealer.deck[0].isBJ) investment += investment/2
        winner = whoWinner(player1,dealer)

        delay()
        println()
        println("점수를 확인합니다.")
        println()

        showScore(player1)
        showScore(dealer)

        println()

        winPrize(winner, investment,player1.deck[0].isBJ || dealer.deck[0].isBJ)
        if(winner.deck[0].Scr != 0) {
            betMoney(dealer, investment, player1.deck[0].isBJ)
            betMoney(player1, investment, dealer.deck[0].isBJ)
            println(" 획득한 금액은 " + investment + "원 입니다.")
        }


        println(player1.pName + "의 총 잔액은 " + player1.Budjet)
        println(dealer.pName + "의 총 잔액은 " + dealer.Budjet)

        resetDeck(player1,dealer,deck)

        if(player1.Budjet == 0 || dealer.Budjet == 0)
            break
        println()
        println("그만 하시려면 exit, 계속 하시려면 아무 글자 입력")
        if(readLine().equals("exit",true)) break
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