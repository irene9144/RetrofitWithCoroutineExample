package com.example.coroutineexample2.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.coroutineexample2.model.Company
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    val companyList = liveData(Dispatchers.IO) {
        try {
            val response = repository.getCompanyList()
            Log.e("smkwon","$response")
//            flow {
//                emit(response.data)
//            }.asLiveData(Dispatchers.IO)
            val gson = Gson()
            val companyList = (response.data as List<Map<String, Any>>).map{
                gson.fromJson(gson.toJson(it), Company::class.java)
            }
            emit(companyList)
//            emit(response.data)

        } catch (e: Exception) {
            emit(emptyList<Company>())

        }
    }
}
