package com.example.manipulatestate.model

data class Post(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)