package com.example.myfirstappkotlinmultiplataform.data.User

import com.example.myfirstappkotlinmultiplataform.domain.User.User
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore

class UserRepository {
    companion object {
        suspend fun getUsers() : List<User> {
            val firebaseFirestore = Firebase.firestore
            try {
                val userResponse = firebaseFirestore.collection( "User").get()
                return userResponse.documents.map {
                    it.data()
                }
            } catch (e: Exception) {
                throw e
            }
        }
    }
}