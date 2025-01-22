package kotlinsource.compose

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async {doSomethingUsefulThree() }
        val two = async {doSomethingUsefulFour() }
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulThree(): Int{
    println("doSomethingUsefulOne")
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulFour(): Int{
    println("doSomethingUsefulTwo")
    delay(1000L)
    return 29
}