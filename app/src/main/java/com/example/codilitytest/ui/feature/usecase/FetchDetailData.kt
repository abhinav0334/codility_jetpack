package com.example.codilitytest.ui.feature.usecase

import com.example.codilitytest.repository.MainRepository
import com.example.codilitytest.ui.feature.data.DataModel
import javax.inject.Inject


class FetchDetailData @Inject constructor(
    private val repository: MainRepository
)  {
    suspend fun invoke(): MutableList<DataModel>? {
        val data = repository.fetchDetailData()
        if (data.isNotEmpty()){
            val dataList = mutableListOf<DataModel>()
            data.forEach {
                val dataDetail = DataModel(
                    schemeCode = it.schemeCode.toString(),
                    schemeName = it.schemeName
                )
                dataList.add(dataDetail)
            }
            return dataList
        }
        return null
    }
}


