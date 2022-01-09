package com.example.mvc.db

import java.util.*

abstract class MemoryDbRepositoryImpl<T:MemoryDbEntity>:MemoryDbRepository<T> {

    val db=mutableListOf<T>()
    var index=0

    override fun findById(index: Int): T? {
        return db.firstOrNull{it -> it.index==index}
    }
    override fun save(entity:T): T? {
        var optionalEntity= db.firstOrNull{it -> it.index==index}

        if(optionalEntity!=null){
            var preIndex=optionalEntity.index
            entity.index=preIndex
            deleteById(index)
            db.add(entity)
            return entity
        }else{
            index++
            entity.index=index
            db.add(entity)
            return entity
        }
    }
    override fun deleteById(index:Int){
        var optionalEntity= db.firstOrNull{it -> it.index==index}
        if (optionalEntity != null) {
            optionalEntity.index?.let {
                db.removeAt(it)
            }
        }
    }
    override fun listAll():List<T>{
        return db
    }
}