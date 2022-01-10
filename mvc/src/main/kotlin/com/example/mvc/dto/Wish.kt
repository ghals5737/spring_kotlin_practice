package com.example.mvc.dto

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "WISH")
data class Wish(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var wishId:Long,
    var title:String?,
    var category:String?,
    var address:String?,
    var readAddress:String?,
    var homePageLink:String?,
    var imageLink:String?,
    var isVisit:Boolean?,
    var visitCount:Int?,
    var lastVisitDate: Date?
)