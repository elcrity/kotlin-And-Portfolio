package Port.Test

fun inputCheck() :Int{//입력값 null 체크
    while(true) {
        println("몇라운드로 게임을 시작할까요?")
        val input = readLine()//숫자 입력

        if(input.equals("")) {//숫자 미입력시 반복
            println("숫자가 입력되지 않음. 확인해주세요")
            continue
        }
        else
            return input!!.toInt()
        break
    }
}