package com.example.mvc.repository

import com.example.mvc.entity.Wish
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface WishRepository:JpaRepository<Wish,Long> {
    fun findByWishId(wishId:Long):Wish
    @Transactional
    fun deleteByWishId(wishId:Long)
    fun existsByWishId(wishId:Long):Boolean
}