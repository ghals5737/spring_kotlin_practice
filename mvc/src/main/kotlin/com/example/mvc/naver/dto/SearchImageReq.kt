package com.example.mvc.naver.dto

import lombok.Data
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

@Data
data class SearchImageReq(
    var query:String="",
    var display:Int=1,
    var start:Int=1,
    var sort:String="sim",
    var filter:String="all"
){
    fun toMultiValueMap():MultiValueMap<String,String>{
        val map=LinkedMultiValueMap<String,String>()

        map.add("query",query)
        map.add("display", display.toString())
        map.add("start",start.toString())
        map.add("sort",sort)
        map.add("filter",filter)
        return map
    }
}
