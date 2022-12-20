package BlackJack

fun inputCheck() :Int{//입력값 null 체크
    while(true) {
        val input = readLine()//숫자 입력

        if(input.equals("")) {//숫자 미입력시 반복
            println("숫자가 입력되지 않음. 확인해주세요")
            continue
        }
        else
            return input!!.toInt()
    }
}

fun costCheck(player : Deck, dealer: Deck) :Int{//입력값 null 체크
    while(true) {
        val input = readLine()//숫자 입력

        if(input.equals("")) {//숫자 미입력시 반복
            return 10
        }
        else if(player.Budjet < input!!.toInt() || dealer.Budjet < input.toInt()){
            println("남은 잔액 확인, 플레이어나 딜러의 남은 금액보다 높은 금액으로는 베팅할수 없습니다.")
        }
        else if(input.toInt() < 10){
            println("최소 베팅액은 10원입니다.")
        }
        else if(input.toInt() > 9) return input.toInt()
    }
}


fun yesAce(user: Deck){
    for(i in 0..user.Card.size-1){
        if(user.Card[i].value == 1){
            println(
                """${user.Card[i].pattern}${user.Card[i].name}를 11로 계산하시겠습니까?
                        |1. 예
                        |2. 아니요
                    """.trimMargin()
            )
            val check = inputCheck()
            when(check){
                1 -> {
                    user.Card[i].value = 11
                    user.Scr += 10
                    ShowHandCard(user)
                }
            }
        }
    }
}

