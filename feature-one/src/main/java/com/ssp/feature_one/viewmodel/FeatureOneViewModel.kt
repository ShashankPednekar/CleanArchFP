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

    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> = _progress

    fun fetchPhotos() {
        viewModelScope.launch {
            _progress.value = true
            val response = photosRepository.fetchPhotoDetails()
            _posts.value = response
            _progress.value = false
        }
    }
}