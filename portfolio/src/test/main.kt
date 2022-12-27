package test

import main.*

class tDeck(
    val pName: String,//덱을 가진 플레이어 이름
    var Budjet :Int = 100,
    var Scr : Int = 0,
    val Card : ArrayList<Card> = ArrayList(),//플레이어가 가지고 있는 덱
    var isBJ : Boolean = false
): ArrayList<tDeck>()


fun main() {
//    var winner : Player
    val dealer = makePlayerT("딜러",500)
    val player1 = ArrayList<tDeck>()
    val testDeck = ArrayList<tDeck>()
    val testDeck1 = ArrayList<tDeck>()
    var split = 0
    val aceNum : ArrayList<Int> = ArrayList()
    println("1")
    player1.add(tDeck("플레이어1"))
    testDeck.add(tDeck("1번 테스트"))
    testDeck1.add(tDeck("2번 테스트"))
//게임실행 본문

//        var investment = costCheck(player1,dealer)

    val testCard1 = Card("A","T",1)
    val testCard2 = Card("10","T",10)
    println("2")
    testDeck1[0].Card.add(testCard1)
    testDeck1[0].Card.add(testCard2)
    println("3")
    for(i in 0 .. 1) {
        drawCardT(player1[0], testDeck1[0], aceNum)
    }
//    println("현재 카드 덱의 숫자는 " + testDeck[0].Card.size +"입니다.")
    showHandCardT(player1)
    println(player1[0].Card[0].name)
    println(aceNum)


}

//fun main() {
//    var winner : Player
//    val dealer = makePlayerT("딜러",500)
//    val player1 = Player("d")
//    val testDeck = ArrayList<tDeck>()
//    val testDeck1 = ArrayList<tDeck>()
//    var split = 0
//    val aceNum : ArrayList<Int> = ArrayList()
//    println("1")
//    player1.add(tDeck())
//    testDeck.add(tDeck())
//    testDeck1.add(tDeck())
////게임실행 본문
//
////        var investment = costCheck(player1,dealer)
//
//    val testCard1 = Card("A","T",1)
//    val testCard2 = Card("10","T",10)
//    println("2")
//    testDeck1[0].Card.add(testCard1)
//    testDeck1[0].Card.add(testCard2)
//    println("3")
//    for(i in 0 .. 1) {
//        drawCardT(player1[0], testDeck1[0], aceNum)
//    }
////    println("현재 카드 덱의 숫자는 " + testDeck[0].Card.size +"입니다.")
//    showHandCardT(player1)
////    println(player1[0].Ca
//}