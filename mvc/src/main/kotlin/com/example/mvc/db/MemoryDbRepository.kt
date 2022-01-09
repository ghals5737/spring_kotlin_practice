package com.example.mvc.db

import java.util.*

interface MemoryDbRepository<T> {
    fun findById(index:Int):T?
    fun save(entity:T):T?
    fun deleteById(index:Int)
    fun listAll():List<T>
}