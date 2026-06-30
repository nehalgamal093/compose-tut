package com.example.compose_tut.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_tut.data.models.Post
import com.example.compose_tut.ui.theme.Pink80
import com.example.compose_tut.ui.theme.Purple40
import com.example.compose_tut.viewModel.PostViewModel

@Composable
fun PostListScreen (viewModel: PostViewModel = PostViewModel()){
val posts by viewModel.posts
    if(posts.isEmpty()){
        CircularProgressIndicator()
    }else{
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(posts){
              post->  PostCard(post)
            }
        }
    }




}

@Composable
fun PostCard(post: Post){
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(Pink80)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Post title ${post.title}", style = MaterialTheme.typography.bodyLarge, color = Purple40)
            Text(text = "Post body ${post.body}", style = MaterialTheme.typography.bodyLarge, color = Purple40)
        }
    }
}