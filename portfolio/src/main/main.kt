package BlackJack

fun main() {
    println("""1. 블랙잭
        |2. 종료
    """.trimMargin())
    while(true) {
        val input = readLine()
        when(input) {
            "1" -> {
                BlackJack()
                println("""다시 시작 - 1
                    |종료 - 2
                """.trimMargin())
            }
            "2" -> break
            else -> println("잘못된 입력")
        }

    }
}