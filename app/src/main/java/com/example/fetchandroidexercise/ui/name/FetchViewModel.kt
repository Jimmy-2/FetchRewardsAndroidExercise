package com.example.fetchandroidexercise.ui.name

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchandroidexercise.network.FetchApi
import com.example.fetchandroidexercise.network.FetchName
import kotlinx.coroutines.launch

class FetchViewModel : ViewModel() {
    //Error message that will be displayed in fragment if API fails to load
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage


    //List that contains the FetchNames
    private val _fetchItems = MutableLiveData<List<FetchName>>()
    val fetchItems: LiveData<List<FetchName>> = _fetchItems

    init {
        getFetchNames()
    }

    private fun getFetchNames() {
        viewModelScope.launch {
            try {
                //Filter out json objects with names that have null or empty values.
                //Then sort the list by listId and then name
                val namesList =
                    FetchApi.retrofitService.getNames().filter { it.name != null && it.name != "" }
                        .sortedWith(compareBy({ it.listId }, { it.name }))
                _fetchItems.value = namesList

            } catch (e: Exception) {
                _errorMessage.value = "Failure: ${e.message}"
            }

        }
    }
}

