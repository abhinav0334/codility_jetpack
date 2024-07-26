package com.example.codilitytest.repository

import com.example.codilitytest.api.ApiService
import com.example.codilitytest.model.DataModelResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun fetchDetailData(): List<DataModelResponse> {
        return withContext(Dispatchers.IO) {
            apiService.getDetailData()
        }
    }
}

