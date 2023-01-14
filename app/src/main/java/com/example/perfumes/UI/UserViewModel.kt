package com.example.perfumes.UI

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.perfumes.data.database.AppDatabase
import com.example.perfumes.data.database.user.UserRepository
import com.example.perfumes.data.database.user.UserTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(repository: UserRepository, application: Application): AndroidViewModel(application) {

    private lateinit var usersData: LiveData<List<UserTable>>
    private val repository: UserRepository

    init {

        val userDao = AppDatabase.getDatabase(application).userDao

        this.repository = UserRepository(userDao)

        viewModelScope.launch {

            usersData = repository.getUsers()
        }
    }

    fun insertUser(userTable: UserTable) {

        viewModelScope.launch(Dispatchers.IO) {

            repository.insertUser(userTable)
        }
    }

    fun login(email: String, password: String) : Boolean {

        viewModelScope.launch(Dispatchers.IO) {

            repository.login(email, password)
        }

        return true
    }

    fun is_taken(email: String) : Boolean {

        viewModelScope.launch(Dispatchers.IO) {

            repository.is_taken(email)
        }

        return true
    }
}