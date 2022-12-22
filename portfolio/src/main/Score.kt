package main

fun showScore(deck:Deck){
    when {
        deck.Scr in 0..21 ->{
            delay()
            print(deck.pName + "의 점수는 " + deck.Scr +"점 입니다")
            println ()
        }
        deck.Scr == -1 || deck.Scr>21->{
            delay()
            print(deck.pName + "의 점수는 " + deck.Scr +"점 입니다")
            print(deck.pName + "는 버스트 됐습니다.")
            println ()
        }

    }
}


