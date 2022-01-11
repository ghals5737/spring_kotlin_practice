package com.example.mvc.naver

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class NaverClient(
    @Value("#{naver.client.id}")
    var naverClientId:String,
    @Value("#{naver.client.secret}")
    var naverClientSecret:String,
    @Value("#{naver.url.search.local}")
    var naverLocalUrl:String,
    @Value("#{naver.url.search.local}")
    var naverImageUrl:String
)
