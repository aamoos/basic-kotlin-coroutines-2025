package kotlinsource.compose

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) {doSomethingUsefulFive() }
        val two = async(start = CoroutineStart.LAZY) {doSomethingUsefulSix() }

        one.start()
        two.start()
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulFive(): Int{
    println("doSomethingUsefulOne")
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulSix(): Int{
    println("doSomethingUsefulTwo")
    delay(1000L)
    return 29
}