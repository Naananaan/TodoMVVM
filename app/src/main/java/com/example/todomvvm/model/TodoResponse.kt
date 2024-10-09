package com.example.todomvvm.model

import com.google.gson.annotations.SerializedName

data class TodoResponse(
    val id: Int,
    val title: String,
    @SerializedName("is_completed") val isCompleted: Boolean // Using @SerializedName for clarity
)