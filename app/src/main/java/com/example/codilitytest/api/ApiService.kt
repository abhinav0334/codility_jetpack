package com.example.codilitytest.api

import com.example.codilitytest.model.DataModelResponse
import retrofit2.http.GET

interface ApiService {

    @GET("mf")
    suspend fun getDetailData(): List<DataModelResponse>
}
