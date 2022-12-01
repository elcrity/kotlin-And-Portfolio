package Port

import java.util.Random

fun randomDice(added :Int = 0, base: Int = 20) = Random().nextInt(base-added)+1+added