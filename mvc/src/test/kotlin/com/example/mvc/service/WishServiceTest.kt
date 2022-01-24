package com.example.mvc.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WishServiceTest {

    @Autowired
    lateinit var wishService: WishService

    @Test
    fun WishServiceTest(){
        var result=wishService.search("갈비집")
        println(result)
        Assertions.assertNotNull(result)
    }

}