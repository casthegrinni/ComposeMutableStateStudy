package com.example.manipulatestate.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.manipulatestate.model.Post
import com.example.manipulatestate.service.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val posts: MutableState <List<Post>> = mutableStateOf(emptyList())
    private val apiService = RetrofitInstance.api

    fun getPosts() {
        viewModelScope.launch {
            try {
                val response = apiService.getPosts()

                posts.value = response
            } catch (e: Exception) {
                // Handle errors here
            }
        }
    }
}
