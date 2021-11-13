package com.teedjay

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import javax.enterprise.context.ApplicationScoped
import kotlin.random.Random
import kotlin.system.measureTimeMillis

@ApplicationScoped
class DoStuffInParallel {

    fun callMultipleServices(vararg input: String): String {
        val res : String
        val timemillis = measureTimeMillis {
            res = getAll(texts = input)
        }
        println("callMultipleServices : returned '$res' using ${timemillis}ms")
        return res
    }

    fun getAll(vararg texts: String): String = runBlocking {
        val a = async { getResult(texts[0]) }
        val b = async { getResult(texts[1]) }
        val c = async { getResult(texts[2]) }
        "${a.await()} ${b.await()} ${c.await()}"
    }

    suspend fun getResult(text : String): String {
        val wait = 5000 + Random.nextLong(15000)
        delay(wait)
        println("getResult : returned '$text' in ${wait}ms")
        return text;
    }

}