package com.example.mvc.service

import com.example.mvc.dto.WishDto
import com.example.mvc.naver.NaverClient
import com.example.mvc.naver.dto.SearchImageReq
import com.example.mvc.naver.dto.SearchLocalReq
import org.springframework.stereotype.Service

@Service
class WishService(
    val naverClient: NaverClient
) {
    fun search(query: String):WishDto {

        //지역검색
        val searchLocalReq=SearchLocalReq()
        searchLocalReq.query=query

        val searchLocalRes=naverClient.searchLocal(searchLocalReq)

        if(searchLocalRes?.total!! >0){
            var item=searchLocalRes.items.first()

            var itemQuery=item.title.replace("<[^>]*>".toRegex(),"")
            var searchImageReq=SearchImageReq(itemQuery)

            var searchImageRes=naverClient.searchImage(searchImageReq)

            if(searchImageRes?.total!!>0){
                var imageItem=searchImageRes.items.first()

                var result=WishDto().apply {
                    this.title=item.title
                    this.category= item.category
                    this.address=item.address
                    this.readAddress=item.roadAddress
                    this.homePageLink=item.link
                    this.imageLink=imageItem.link
                }

                return result
            }
        }
        return WishDto()
    }
}