package com.example.todomvvm.network

import com.example.todomvvm.model.TodoJ
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TodosApi {
    @GET("todos")
    suspend fun getTodos(): List<TodoJ>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        val todosService: TodosApi by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TodosApi::class.java)
        }
    }
}
