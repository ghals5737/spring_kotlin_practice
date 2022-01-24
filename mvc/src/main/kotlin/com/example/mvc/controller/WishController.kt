package com.example.mvc.controller

import com.example.mvc.dto.WishDto
import com.example.mvc.entity.Wish
import com.example.mvc.service.WishService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Api(description = "네이버 검색 API 사용한 맛집검색")
@RestController
@RequestMapping("/api/restaurant")
class WishController (
    var wishService: WishService
        ){

    @ApiOperation(value = "지역 검색", notes = "검색어로 지역검색")
    @GetMapping("/search")
    fun search(@RequestParam query:String):WishDto{
        return wishService.search(query)
    }

}