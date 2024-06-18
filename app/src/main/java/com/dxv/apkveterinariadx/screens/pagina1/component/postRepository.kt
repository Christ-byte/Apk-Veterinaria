package com.dxv.apkveterinariadx.screens.pagina1.component

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class PostRepository {
    private val db = FirebaseFirestore.getInstance()
    private val postsCollection = db.collection("posts")

    fun getPosts(callback: (List<Post>) -> Unit) {
        postsCollection.get()
            .addOnSuccessListener { result ->
                val posts = result.map { document ->
                    document.toObject(Post::class.java)
                }
                callback(posts)
            }
            .addOnFailureListener { exception ->
                Log.w("PostRepository", "Error getting documents: ", exception)
                callback(emptyList())
            }
    }
}
