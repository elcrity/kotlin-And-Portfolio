package main

class Player(
    val pName: String,//덱을 가진 플레이어 이름
    var Budjet :Int = 100,
    val deck : ArrayList<Deck> = ArrayList(arrayListOf<Deck>().plus(Deck())) // Deck 타입의 ArrayList에 Deck 형태의 인스턴스 생성
)

fun makePlayer(name: String, cost: Int = 100) = when(name){
    "dealer" -> Player("딜러",500)
       else -> Player(name,cost)
}

fun addPlayerDeck(name : Player) : Boolean = name.deck.add(Deck())
