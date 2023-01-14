package com.example.perfumes.data.database.user

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(userTable: UserTable) = userDao.insertUser(userTable)


    suspend fun is_taken(email: String) = userDao.is_taken(email)

    suspend fun login(email: String, password: String) = userDao.login(email, password)

    suspend fun getUsers() = userDao.getUsers()
}