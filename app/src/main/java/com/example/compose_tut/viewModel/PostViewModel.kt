package com.example.compose_tut.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.example.compose_tut.data.api.RetrofitInstance
import com.example.compose_tut.data.models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {

    private val _posts = mutableStateOf<List<Post>>(emptyList())

    val posts: State<List<Post>>  = _posts

    init {
        fetchPosts()
    }
    private  fun fetchPosts(){
        viewModelScope.launch(Dispatchers.IO) {

            try{
                _posts.value = RetrofitInstance.api.getPosts()
                Log.d("Posts", "Posts are = ${_posts.value}")
            } catch (e: Exception){
                Log.d("Posts Error", "Posts error = ${e.toString()}")
            }
        }
    }
}