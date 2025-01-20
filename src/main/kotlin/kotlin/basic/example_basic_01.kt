package kotlin.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//structured concurrency
fun main() =
    runBlocking {
        launch {
            myWorld()
        }

        println("Hello,")
}

suspend fun myWorld(){
    delay(1000L)
    println("world.")
}