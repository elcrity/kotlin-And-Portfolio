package main

class Player(
    var pName: String,//덱을 가진 플레이어 이름
    var Budjet :Int = 100,
    var deck : ArrayList<Deck> = ArrayList()
)

fun makePlayer(name: String, cost: Int = 100): Player = Player(name,cost)//플레이어 이름 + Card형태의(name,pattern,value값) 배열 생성