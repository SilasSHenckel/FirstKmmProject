package com.example.myfirstappkotlinmultiplataform.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.myfirstappkotlinmultiplataform.data.User.UserRepository
import com.example.myfirstappkotlinmultiplataform.domain.User.User


@Composable
fun Home() {
    MaterialTheme {
        Column(Modifier.fillMaxWidth()) {
            var list by remember{ mutableStateOf(listOf<User>()) }
            LaunchedEffect( Unit ) {
                list = UserRepository.getUsers()
            }
            LazyColumn {
                items(list) {
                    UserItem(it)
                }
            }
        }
    }
}

@Composable
fun UserItem(user: User) {
    Column {
        Text(
            text = user.name ?: "Lucas"
        )
        Text(
            text = user.age
        )
    }
}