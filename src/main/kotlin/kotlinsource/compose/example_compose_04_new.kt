package kotlinsource.compose

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = somethingUsefulOneAsync()
        val two = somethingUsefulTwoAsync()
        runBlocking {
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Completed in $time ms")
}

fun somethingUsefulOneAsync() = GlobalScope.async {
    doSomethingUsefulSeven()
}

fun somethingUsefulTwoAsync() = GlobalScope.async {
    doSomethingUsefulEight()
}

suspend fun doSomethingUsefulSeven(): Int{
    println("doSomethingUsefulOne")
    delay(3000L)
    return 13
}

suspend fun doSomethingUsefulEight(): Int{
    println("doSomethingUsefulTwo")
    delay(3000L)
    return 29
}