package com.example.coroutineexample2.model

import com.google.gson.annotations.SerializedName

data class Company (
    @SerializedName("companyId") val companyId: Int,
    @SerializedName("name") val name: String
)