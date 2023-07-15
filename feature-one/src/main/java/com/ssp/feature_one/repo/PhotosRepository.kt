package com.ssp.feature_one.repo

import android.util.Log
import com.ssp.core.NetworkProvider
import com.ssp.feature_one.data.Post
import javax.inject.Inject

class PhotosRepository @Inject constructor(
    private val networkProvider: NetworkProvider
) {
    private val TAG = "PhotosRepository"
    
    private val api: PostsApiService
        get() = networkProvider.getApi(
            PostsApiService::class.java,
            "https://jsonplaceholder.typicode.com/"
        )

    suspend fun fetchPhotoDetails(): List<Post> {
        val response = api.getPosts()
        Log.d(TAG, "fetchPhotoDetails: ")
        return response
    }
}