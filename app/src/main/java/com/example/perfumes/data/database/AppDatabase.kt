package com.example.perfumes.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.perfumes.data.database.user.UserDao
import com.example.perfumes.data.database.user.UserTable

@Database(entities = [UserTable::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao : UserDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null


        fun getDatabase(context: Context): AppDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "perfume_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}