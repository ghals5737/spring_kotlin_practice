package com.example.mvc.naver.dto

import lombok.Data
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

@Data
data class SearchLocalReq(
    var query:String="",
    var display:Int=1,
    var start:Int=1,
    var sort:String="random"
){
    fun toMultiValueMap():MultiValueMap<String,String>{
        val map=LinkedMultiValueMap<String,String>()

        map.add("query",query)
        map.add("display", display.toString())
        map.add("start",start.toString())
        map.add("sort",sort)

        return map
    }
}
