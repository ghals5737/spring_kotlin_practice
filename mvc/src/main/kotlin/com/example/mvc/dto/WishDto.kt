package com.example.mvc.dto

import java.util.*

data class WishDto(
    var index:Long=0,
    var title:String="",
    var category:String?=null,
    var address:String="",
    var readAddress:String="",
    var homePageLink:String="",
    var imageLink:String="",
    var isVisit:Boolean=false,
    var visitCount:Int=0,
    var lastVisitDate: Date?=null
)