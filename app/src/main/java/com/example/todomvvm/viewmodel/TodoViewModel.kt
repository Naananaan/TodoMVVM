package com.example.todomvvm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todomvvm.model.TodoJ
import com.example.todomvvm.network.TodosApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {

    // StateFlow to hold the list of todos
    private val _todos = MutableStateFlow<List<TodoJ>>(emptyList())
    val todos: StateFlow<List<TodoJ>> = _todos

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Accessing the API service instance
                val todosApi = TodosApi.todosService
                val fetchedTodos = todosApi.getTodos()
                _todos.value = fetchedTodos // Emit the new list of todos
            } catch (e: Exception) {
                Log.d("TodoViewModel", "Error fetching todos: ${e.message}")
            }
        }
    }
}
