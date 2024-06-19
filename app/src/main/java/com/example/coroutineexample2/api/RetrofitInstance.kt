package com.example.coroutineexample2.api

import com.example.coroutineexample2.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
//    private val retrofitClient by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
    var retrofitService: ApiService? = null

    fun getInstance(): ApiService {
        if(retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofitService = retrofit.create(ApiService::class.java)
        }
        return retrofitService!!
    }
}