package com.example.manipulatestate.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.manipulatestate.model.Post
import com.example.manipulatestate.viewModel.MainViewModel


@Composable
fun PostList(viewModel: MainViewModel = MainViewModel()) {
    val posts: List<Post> by viewModel.posts

    Column(modifier = Modifier.padding(8.dp)) {
        Text(modifier = Modifier.padding(bottom = 12.dp),
            text = "Exemplo de chamada api",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
        )

        LazyColumn {
            items(items = posts) {
                posts.forEach { post ->
                    Text(text = post.title,
                        modifier = Modifier
                            .padding(bottom = 10.dp))
                }
            }
        }
    }

    DisposableEffect(Unit) {
        viewModel.getPosts()
        onDispose {

        }
    }
}