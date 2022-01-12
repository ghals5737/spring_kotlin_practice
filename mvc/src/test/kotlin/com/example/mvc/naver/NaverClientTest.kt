package com.example.mvc.naver

import com.example.mvc.naver.dto.SearchImageReq
import com.example.mvc.naver.dto.SearchLocalReq
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class NaverClientTest {

    @Autowired
    lateinit var naverClient: NaverClient

    @Test
    fun searchLocalTest(){

        val search=SearchLocalReq()
        search.query="갈비집"

        val result=naverClient.searchLocal(search)
        println(result)
    }

    @Test
    fun searchImageTest(){

        val search= SearchImageReq()
        search.query="갈비집"

        val result=naverClient.searchImage(search)
        println(result)
    }
}