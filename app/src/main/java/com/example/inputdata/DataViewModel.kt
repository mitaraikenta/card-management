package com.example.inputdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel: ViewModel() {

    private var _inputData = MutableLiveData(listOf<TodoItem>())
    var inputData: LiveData<List<TodoItem>> = _inputData

    private var _cardplace = MutableLiveData(listOf<TodoItem>())
    var cardplace: LiveData<List<TodoItem>> = _cardplace

    fun addItem(item: TodoItem){
        _inputData.value = _inputData.value!! + listOf(item)
    }

    fun addPlace(item: TodoItem){
        _cardplace.value = _cardplace.value!! + listOf(item)
    }

    fun removeItem(item: TodoItem) {
        _inputData.value = _inputData.value!!.toMutableList().also {
            it.remove(item)
        }
    }
}