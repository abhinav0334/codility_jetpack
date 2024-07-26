package com.example.kotlindemo.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codilitytest.model.DataModelResponse
import com.example.codilitytest.repository.MainRepository
import com.example.codilitytest.ui.feature.data.DataModel
import com.example.codilitytest.ui.feature.usecase.FetchDetailData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val fetchDetailData: FetchDetailData
) : ViewModel() {

    private val _detailData = MutableLiveData<List<DataModel>>()
    val detailData: LiveData<List<DataModel>> = _detailData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    @SuppressLint("NullSafeMutableLiveData")
    fun fetchDetailData() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val data = fetchDetailData.invoke()
                Log.d("MainActivityVM","${data}")
                if(data?.isNotEmpty() == true){
                    _detailData.value = data
                }
            } catch (e: Exception) {
                Log.d("MainActivityVM","${e.message}")
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }
}