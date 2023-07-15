package com.ssp.feature_one.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssp.feature_one.data.Post
import com.ssp.feature_one.repo.PhotosRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class FeatureOneViewModel @Inject constructor(
    private val photosRepository: PhotosRepository
) : ViewModel() {
    private val TAG = "FeatureOneViewModel"

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    fun fetchPhotos() {
        viewModelScope.launch {
            val response = photosRepository.fetchPhotoDetails()
            _posts.value = response
        }
    }
}