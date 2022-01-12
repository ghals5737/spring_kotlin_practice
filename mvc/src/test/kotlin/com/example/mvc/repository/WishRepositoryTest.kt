package com.example.mvc.repository

import com.example.mvc.entity.Wish
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ExtendWith(SpringExtension::class)
class WishRepositoryTest {

    @Autowired
    lateinit var wishRepository: WishRepository

    fun create():Wish{
        return Wish(
            0,
            "title",
            "category",
            "address",
            "readAddress",
            "",
            "",
            false,
            0,
            null
        )
    }

    @Test
    fun saveWishTest(){
        var wish=create()
        var expected=wishRepository.save(wish)

        Assertions.assertNotNull(expected)
        Assertions.assertEquals(wish,expected)
    }

    @Test
    fun findByWishIdTest(){
        var wish=create()
        wishRepository.save(wish)
        var expected=wishRepository.findByWishId(1)

        Assertions.assertEquals(wish,expected)
        Assertions.assertEquals(1,expected.wishId)
    }

    @Test
    fun findByDelete(){
        var wish=create()
        wishRepository.save(wish)
        wishRepository.deleteByWishId(1)
        Assertions.assertEquals(false,wishRepository.existsByWishId(1))
    }

    @Test
    fun findAllTest(){
        var wish1=create()
        wishRepository.save(wish1)
        var wish2=create()
        wishRepository.save(wish2)
        var expected=wishRepository.findAll()
        Assertions.assertEquals(2,expected.size)
    }
}