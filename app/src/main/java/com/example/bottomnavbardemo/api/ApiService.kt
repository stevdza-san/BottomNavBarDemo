package com.example.bottomnavbardemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

interface ApiService{
    @GET("todos")
    suspend fun getTodos(): List<Todo>

    companion object{
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}