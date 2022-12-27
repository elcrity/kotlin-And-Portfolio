package main

fun yesAce(user: Player){
    for(i in 0 until user.deck[0].Card.size){
        if(user.deck[0].Card[i].value == 1){
            println(
                """${user.deck[0].Card[i].pattern}${user.deck[0].Card[i].name}을/를 11로 계산하시겠습니까?
                        |1. 예
                        |2. 아니요
                    """.trimMargin()
            )
            when(inputCheck()){
                1 -> {
                    user.deck[0].Card[i].value = 11
                    user.deck[0].Scr += 10
                    showCardAndScore(user)
                }
            }
        }
    }
}

fun dealerAce(dealer: Player, player: Player){
    println("딜러가 고민중입니다.")
    delay()
    for(i in 0 until dealer.deck[0].Card.size){
        when (dealer.deck[0].Card[i].value) {
            1 -> when{
                dealer.deck[0].Scr < player.deck[0].Scr -> {
                    if(dealer.deck[0].Scr + 10 > player.deck[0].Scr && dealer.deck[0].Scr +10 < 22) {
                        dealer.deck[0].Card[i].value = 11
                        dealer.deck[0].Scr += 10
                        println("딜러가 " + dealer.deck[0].Card[i].pattern + dealer.deck[0].Card[i].name + "카드를 11점으로 계산하기 시작합니다.")
                        showScore(dealer)
                    }else break
                }
                dealer.deck[0].Scr > player.deck[0].Scr -> {
                    break
                }
            }
            11 -> when{
                dealer.deck[0].Scr > 21 -> {
                    if(dealer.deck[0].Scr - 10 < 21){
                        dealer.deck[0].Card[i].value = 1
                        dealer.deck[0].Scr -= 10
                        println("딜러가 " + dealer.deck[0].Card[i].pattern + dealer.deck[0].Card[i].name + "카드를 1점으로 계산하기 시작합니다.")
                        showScore(dealer)
                    }else break
                }
            }
            else -> continue
        }
    }
}