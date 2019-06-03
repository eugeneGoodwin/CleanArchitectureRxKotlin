package com.example.soft.cleanarchitecturerxkotlin.data.mapper

import com.example.soft.cleanarchitecturerxkotlin.data.model.Post
import com.example.soft.cleanarchitecturerxkotlin.domain.model.DPost
import javax.inject.Inject

class PostMapper @Inject constructor() : Mapper<Post, DPost> {
    override fun mapFromEntity(type: Post) = DPost(type.userId, type.id, type.title, type.body)
}