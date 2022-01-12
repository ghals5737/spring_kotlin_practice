package com.example.mvc.service

import com.example.mvc.dto.WishDto

interface WishService {
    fun search(query:String):WishDto
}