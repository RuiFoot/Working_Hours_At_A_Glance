package com.example.myapplication.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.LawFAQDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LawViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _searchResults = MutableLiveData<List<String>>()
    val searchResults: LiveData<List<String>> get() = _searchResults

    /*
    val lawFAQDatabase = LawFAQDatabase.getInstance(this)

    lifecycleScope.launch(Dispatchers.IO) {
        val faqList =lawFAQDatabase.lawFAQDao().getAllFAQs()
        // 데이터 처리 또는 UI 업데이트 작업
        for (faq in faqList){
            Log.d("LawActivity","Question: ${faq.question}, Answer: ${faq.answer}")
            break
        }
    }

     */

}