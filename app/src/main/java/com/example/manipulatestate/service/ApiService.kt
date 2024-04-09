package com.example.manipulatestate.service

import com.example.manipulatestate.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List <Post>
}