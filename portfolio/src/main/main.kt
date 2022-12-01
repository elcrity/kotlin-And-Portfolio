package Port.Test

fun main(args: Array<String>) {
    var Trg = true
    println("""1. 블랙잭
        |2. 종료
    """.trimMargin())
    while(Trg) {
        var input = readLine()
        when(input) {
            "1" -> {BlackJack()
                println("""다시 시작 - 1
                    |종료 - 2
                """.trimMargin())
            }
            "2" -> Trg = false
            else -> println("잘못된 입력")
        }

    }
}