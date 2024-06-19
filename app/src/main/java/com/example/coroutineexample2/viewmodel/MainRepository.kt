package com.example.coroutineexample2.viewmodel

import com.example.coroutineexample2.api.ApiService
import com.example.coroutineexample2.model.ApiResponse

class MainRepository(private val apiService: ApiService) {
    suspend fun getCompanyList(): ApiResponse {
        return apiService.getCompanyList()
    }
}