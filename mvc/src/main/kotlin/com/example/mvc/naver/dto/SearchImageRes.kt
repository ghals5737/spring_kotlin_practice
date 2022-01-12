package com.example.mvc.naver.dto



data class SearchImageRes (
    var lastBuildDate:String,
    var total:Int,
    var start:Int,
    var display:Int,
    var items:List<SearchLocalItem>

){
    data class SearchLocalItem (
        var title:String,
        var link:String,
        var thumbnail:String,
        var sizeheight:String,
        var sizewidth:String
    )
}



