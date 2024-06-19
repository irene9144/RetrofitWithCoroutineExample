package com.example.coroutineexample2.api

import com.example.coroutineexample2.model.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("app/v1/company")
    suspend fun getCompanyList(): ApiResponse
}

