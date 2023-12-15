package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.LawFAQ

class SharedViewModel : ViewModel() {

    private val _selectedItem = MutableLiveData<LawFAQ>()
    val selectedItem: LiveData<LawFAQ> get() = _selectedItem

    fun setSelectedItem(item: LawFAQ) {
        _selectedItem.value = item
    }
}