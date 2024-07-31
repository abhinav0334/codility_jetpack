package com.example.feature.posts.domain.mapper

import com.example.feature.posts.data.datasources.remote.response.GetPostApiResponse
import com.example.feature.posts.domain.entity.PostEntity

fun GetPostApiResponse.toPostsEntities(): List<PostEntity> {
    return this.map { currentObject ->
        PostEntity(
            schemeCode = currentObject.schemeCode.toString(),
            schemeName = currentObject.schemeName.toString())
    }}
