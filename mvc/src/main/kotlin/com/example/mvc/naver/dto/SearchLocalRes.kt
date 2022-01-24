package com.example.mvc.naver.dto



data class SearchLocalRes (
    var lastBuildDate:String,
    var total:Int,
    var start:Int,
    var display:Int,
    var items:List<SearchLocalItem>

){
    data class SearchLocalItem (
        var title:String,
        var link:String,
        var description:String,
        var category: String?,
        var telephone:String,
        var address:String,
        var roadAddress:String,
        var mapx:Int,
        var mapy:Int
    )
}



