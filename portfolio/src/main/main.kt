package main

fun main() {
    for(i in 0 .. 10)
        println(i)
    println("""1. 블랙잭
        |2. 종료
    """.trimMargin())
    while(true) {
        when(readLine()) {
            "1" -> {
                blackJack()
                println("""다시 시작 - 1
                    |종료 - 2
                """.trimMargin())
            }
            "2" -> break
            else -> println("잘못된 입력")
        }

    }
}