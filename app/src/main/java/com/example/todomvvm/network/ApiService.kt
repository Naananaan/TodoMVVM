package com.example.todomvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


object ApiService {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val instance: TodosApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodosApi::class.java)
    }
}
