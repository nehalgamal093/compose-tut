package com.example.compose_tut.data.api
import com.example.compose_tut.data.models.Post
import retrofit2.http.GET

interface APIService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}