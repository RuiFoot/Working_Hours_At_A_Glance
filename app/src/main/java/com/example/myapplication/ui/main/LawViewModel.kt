package com.example.myapplication.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.example.myapplication.LawFAQ
import com.example.myapplication.LawFAQDatabase
import kotlinx.coroutines.launch

class LawViewModel(application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel

    private val lawFAQDatabase = LawFAQDatabase.getInstance(application)

    private val _searchResults = MutableLiveData<List<LawFAQ>>()
    val searchResults: LiveData<List<LawFAQ>> get() = _searchResults

    fun search(searchMain: String, searchMiddle: String, editText: String) {
        viewModelScope.launch {
            val results = lawFAQDatabase.lawFAQDao().searchFAQs(searchMain, searchMiddle, editText)
            _searchResults.value = results
        }
    }

    fun getDataList(): List<DataModel> {
        val searchResults = searchResults.value ?: emptyList()
        return searchResults.map {
            DataModel(it.main.toString(), it.middle.toString(), it.question.toString())
        }
    }
}