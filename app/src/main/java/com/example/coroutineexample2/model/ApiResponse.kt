package com.example.coroutineexample2.model

data class ApiResponse(
    val success: Boolean,
    val message: String,
    val data: Any
)