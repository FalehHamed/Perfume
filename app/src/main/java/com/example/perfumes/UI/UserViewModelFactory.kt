package com.example.perfumes.UI

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.perfumes.data.database.user.UserRepository

class UserViewModelFactory(
    private  val repository: UserRepository,
    private val application: Application
    ): ViewModelProvider.Factory {

    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(repository, application) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}