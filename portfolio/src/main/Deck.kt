package Port.Test

class Deck(
    var Player: String,//덱을 가진 플레이어 이름
    var Budjet :Int = 100,
    var card : ArrayList<Card> = ArrayList()//플레이어가 가지고 있는 덱
)

fun MakePlayer(name: String): Deck = Deck(name)//플레이어 이름 + Card형태의(name,pattern,value값) 배열 생성

fun SetDeck() : ArrayList<Card>{//정해진 벌수의 카드로 패산 생성
    var num = -1
    num = inputCheck()

//    while(true) {
//        println("몇벌의 카드로 게임을 시작할까요?")
//        val read = readLine()//숫자 입력
//
//        if(read.equals("")) {//숫자 미입력시 반복
//            println("숫자가 입력되지 않음. 확인해주세요")
//            continue
//        }
//        else
//            num = read!!.toInt()
//        break
//    }

    var deck = ArrayList<Card>()

    for(i in 0 .. 52*num-1){
        val card = Card()
        when(i%13){//((0~12)+13*i)까지 각각 A~K
            0 -> card.name = "Ace"
            in 1..9 ->  card.name = ((i%13)+1).toString()
            10 -> card.name = "J"
            11 -> card.name = "Q"
            12 -> card.name = "K"
        }
        when(i%52/13){//13장마다 모양 변경, 카드 한벌 52장마다 초기화
            0 -> card.pattern = "스페이드"
            1 -> card.pattern = "다이아몬드"
            2 -> card.pattern = "하트"
            3 -> card.pattern = "클로버"
        }
//        when(i%13){//1~10까지 카드 값 부여
//            in 0..9 -> card.value = (i%13)+1
//            in 10..12 -> card.value = 10
//        }
        when(i%13){//카드 갯수, 드로우 확인용
            in 0..9 -> card.value = i
            in 10..12 -> card.value = i
        }

        deck.add(card)
    }
    println("현재 카드 덱의 숫자는 " + deck.size +"입니다.")
    return deck
}