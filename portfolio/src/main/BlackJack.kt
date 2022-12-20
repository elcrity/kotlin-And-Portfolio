package BlackJack


fun BlackJack() {
    //게임 시작시 덱, 플레이어 생성
    //라운드 체크
    var winner = Deck()
    val dealerHand = MakePlayer("딜러",500)
    val handCard1 = MakePlayer("1번 플레이어",100)
    val deck = SetDeck()
    while(true) {//게임실행 본문

        println("배팅 금액을 정해주세요. 미입력시 기본 배팅액은 10원입니다.")
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

        println()
        DrawPlayer(handCard1,deck)
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
        DrawDealer(dealerHand,handCard1,deck)
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
        if(handCard1.Scr == 100 || dealerHand.Scr ==100)
            investment += investment/2

        winner = whoWinner(handCard1,dealerHand)
        ShowScore(handCard1)
        ShowScore(dealerHand)

        println()
        betMoney(dealerHand,investment)
        betMoney(handCard1, investment)

        println("승자는 " + winner.pName + "획득한 금액은 " + investment + "원 입니다.")
        winPrize(winner, investment)
        println(handCard1.pName + "의 총 잔액은 " + handCard1.Budjet)
        println(dealerHand.pName + "의 총 잔액은 " + dealerHand.Budjet)
        resetDeck(handCard1,dealerHand,deck)
        if(handCard1.Budjet == 0 || dealerHand.Budjet == 0)
            break

        println("종료 하시려면 1, 계속 하시려면 아무 글자 입력")
        if(readLine() == "1"){
            break
        }
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