package main

fun delay(sec : Long = 500) {
    try {
        Thread.sleep(sec)
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
}