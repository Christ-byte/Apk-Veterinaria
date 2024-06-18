package com.dxv.apkveterinariadx.screens.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenVM : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = mutableStateOf(false)


    fun signEmailPassword(email: String, password: String, home: () -> Unit)
    =viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("LoginScreenVM", "signInWithEmail:success")
                        home()
                    } else {
                        Log.d("LoginScreenVM", "signInWithEmail: ${task.exception?.message}")
                    }

                }.addOnFailureListener {
                    Log.e("LoginScreenVM", "Ya estoy controlado")
                }
//                .addOnFailureListener(faliure)
        }catch (e: Exception){
            Log.d("LoginScreenVM", "signInWithEmail: ${e.message}")
        }
    }


}