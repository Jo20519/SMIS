package com.example.students.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.students.api.ApiService
import com.example.students.api.RetrofitClient
import com.example.students.model.StudentResultDto
import kotlinx.coroutines.launch

class ResultsViewModel : ViewModel() {

    private val _results = MutableLiveData<List<StudentResultDto>>()
    val results: LiveData<List<StudentResultDto>> get() = _results

    fun fetchResults() {
        viewModelScope.launch {
            try {
                val api = RetrofitClient.apiService

                val data = api.getResults()
                _results.postValue(data)
            } catch (e: Exception) {
                _results.postValue(emptyList()) // Handle error gracefully
            }
        }
    }
}
