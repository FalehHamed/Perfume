package com.example.perfumes.data.database.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(userTable: UserTable)

    @Query("SELECT EXISTS(SELECT * FROM users WHERE email = :email)")
    suspend fun is_taken(email: String) : Boolean

    @Query("SELECT EXISTS(SELECT * FROM users WHERE email =:email AND password =:password)")
    suspend fun login(email: String, password: String) : Boolean

    @Query("SELECT * FROM users")
    fun getUsers(): LiveData<List<UserTable>>
}