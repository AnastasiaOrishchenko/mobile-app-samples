package com.example.numbers.ui.fact

import android.content.SharedPreferences
import androidx.lifecycle.*
import com.example.numbers.network.NumbersApi
import com.example.numbers.ui.saved.FACTS_LIST_KEY_VALUE
import kotlinx.coroutines.launch

class SingleFactViewModel(
    private val number: Int,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {
    private val _fact = MutableLiveData<String>()
    val fact: LiveData<String> = _fact

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                _fact.value = NumbersApi.retrofitService.getFact(number)
            } catch (e: Exception) {
                _fact.value = "Failure: ${e.message}"
            }
        }
    }

    fun saveFact() {
        val currentFact = fact.value

        if (currentFact != null) {
            val existingList: Set<String> =
                sharedPreferences.getStringSet(FACTS_LIST_KEY_VALUE, emptySet()) ?: setOf()
            sharedPreferences.edit()
                .putStringSet(FACTS_LIST_KEY_VALUE, existingList.plus(currentFact)).apply()
        }

    }
}

class SingleFactViewModelFactory(
    private val number: Int,
    private val sharedPreferences: SharedPreferences
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SingleFactViewModel(number, sharedPreferences) as T
    }
}