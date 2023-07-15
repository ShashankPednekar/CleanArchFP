package com.ssp.feature_one.repo

import com.ssp.feature_one.data.Post
import retrofit2.http.GET

interface PostsApiService {
    @GET("photos")
    suspend fun getPosts(): List<Post>
}
