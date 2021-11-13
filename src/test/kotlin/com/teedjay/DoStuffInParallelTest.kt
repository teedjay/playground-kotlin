package com.teedjay

import io.quarkus.test.junit.QuarkusTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import javax.inject.Inject

@QuarkusTest
internal class DoStuffInParallelTest {

    @Inject
    lateinit var dsip: DoStuffInParallel

    @Test
    fun callMultipleServices() {
        val result = dsip.callMultipleServices("ola", "bola", "cola")
        assertThat(result, `is`("ola bola cola"))
    }

}