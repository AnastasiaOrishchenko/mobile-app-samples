package com.example.numbers.fact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.numbers.network.NumbersApi
import kotlinx.coroutines.launch

class SingleFactViewModel(private val number: Int) : ViewModel() {
    val fact = MutableLiveData<String>()

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                fact.value = NumbersApi.retrofitService.getFact(number)
            } catch (e: Exception) {
                fact.value = "Failure: ${e.message}"
            }
        }
    }
}

class SingleFactViewModelFactory(private val number: Int) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SingleFactViewModel(number) as T
    }
}