package com.example.mvc.whishlist.repository

import com.example.mvc.db.MemoryDbRepositoryImpl
import com.example.mvc.whishlist.entity.WishListEntity
import org.springframework.stereotype.Repository

@Repository
class WishListRepository<T> : MemoryDbRepositoryImpl<WishListEntity>() {


}