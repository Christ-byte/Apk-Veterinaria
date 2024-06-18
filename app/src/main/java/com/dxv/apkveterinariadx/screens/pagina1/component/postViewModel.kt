package com.dxv.apkveterinariadx.screens.pagina1.component

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostViewModel : ViewModel() {
    private val postRepository = PostRepository()
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        postRepository.getPosts { posts ->
            _posts.value = posts
        }
    }
}
