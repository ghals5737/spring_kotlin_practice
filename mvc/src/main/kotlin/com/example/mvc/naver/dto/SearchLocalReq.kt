package com.example.mvc.naver.dto

import lombok.Data

@Data
data class SearchLocalReq(
    var query:String="",
    var display:Int=1,
    var start:Int=1,
    var sort:String="random"
)
