package com.example.mvc.naver

import com.example.mvc.naver.dto.SearchImageReq
import com.example.mvc.naver.dto.SearchImageRes
import com.example.mvc.naver.dto.SearchLocalReq
import com.example.mvc.naver.dto.SearchLocalRes
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Component
data class NaverClient(
    @Value("\${naver.client.id}")
    var naverClientId:String="",
    @Value("\${naver.client.secret}")
    var naverClientSecret:String="",
    @Value("\${naver.url.local}")
    var naverLocalSearchUrl:String="",
    @Value("\${naver.url.image}")
    var naverImageSearchUrl:String=""
){
    fun searchLocal(searchLocalReq: SearchLocalReq): SearchLocalRes? {
        var uri=UriComponentsBuilder.fromUriString(naverLocalSearchUrl)
            .queryParams(searchLocalReq.toMultiValueMap())
            .build()
            .encode()
            .toUri()

        var headers= HttpHeaders()
        headers.set("X-Naver-Client-Id",naverClientId)
        headers.set("X-Naver-Client-Secret",naverClientSecret)
        headers.contentType= MediaType.APPLICATION_JSON

        var httpEntity=HttpEntity<Any>(headers)
        var responseType=object: ParameterizedTypeReference<SearchLocalRes> () {}

        var responseEntity=RestTemplate().exchange(
            uri,
            HttpMethod.GET,
            httpEntity,
            responseType
        )
        return responseEntity.body
    }

    fun searchImage(searchImageReq: SearchImageReq): SearchImageRes? {
        var uri=UriComponentsBuilder.fromUriString(naverImageSearchUrl)
            .queryParams(searchImageReq.toMultiValueMap())
            .build()
            .encode()
            .toUri()

        var headers= HttpHeaders()
        headers.set("X-Naver-Client-Id",naverClientId)
        headers.set("X-Naver-Client-Secret",naverClientSecret)
        headers.contentType= MediaType.APPLICATION_JSON

        var httpEntity=HttpEntity<Any>(headers)
        var responseType=object: ParameterizedTypeReference<SearchImageRes> () {}

        var responseEntity=RestTemplate().exchange(
            uri,
            HttpMethod.GET,
            httpEntity,
            responseType
        )
        return responseEntity.body
    }
}
