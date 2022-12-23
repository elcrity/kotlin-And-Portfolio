package main

fun inputCheck() :Int{//입력값 null 체크
    while(true) {
        val input = readln()//숫자 입력
        when(if(input == "") -1 else input.toInt()){
            -1 -> println("숫자가 입력되지 않음. 확인해주세요")
            else -> return input.toInt()
        }
    }
}

fun costCheck(player : Deck, dealer: Deck) :Int {//입력값 null 체크
    while (true) {
        println("배팅 금액을 정해주세요. 기본 배팅액은 10원입니다.")
        val input = readln()

        when (val bet: Int = if (input == "") -1 else input.toInt()) {
            -1 -> return 10
            else -> when {
                player.Budjet < bet || dealer.Budjet < bet -> println("남은 잔액 확인, 플레이어나 딜러의 남은 금액보다 높은 금액으로는 베팅할수 없습니다.")
                bet % 5 != 0 -> println("배팅액은 5원 단위입니다.")
                else -> return bet
            }
        }
    }
}



