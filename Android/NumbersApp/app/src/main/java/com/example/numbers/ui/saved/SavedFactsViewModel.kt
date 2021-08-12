package com.example.numbers.ui.saved

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SavedFactsViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {

    private val _facts = MutableLiveData<List<String>>().apply {
        value = emptyList()
    }
    val facts: LiveData<List<String>> = _facts

    init {
        _facts.value = getSaved()
    }

    private fun getSaved(): List<String> {
        return sharedPreferences.getStringSet(FACTS_LIST_KEY_VALUE, emptySet())?.toList()
            ?: emptyList()
    }
}

class SavedFactsViewModelFactory(private val sharedPreferences: SharedPreferences) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SavedFactsViewModel(sharedPreferences) as T
    }
}