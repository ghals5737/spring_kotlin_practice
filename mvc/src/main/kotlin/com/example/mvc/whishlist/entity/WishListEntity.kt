package com.example.mvc.whishlist.entity

import com.example.mvc.db.MemoryDbEntity
import java.util.*

data class WishListEntity(
    var title:String?,
    var category:String?,
    var address:String?,
    var readAddress:String?,
    var homePageLink:String?,
    var imageLink:String?,
    var isVisit:Boolean,
    var visitCount:Int?,
    var lastVisitDate: Date?,
    override var index: Int?
): MemoryDbEntity(index)