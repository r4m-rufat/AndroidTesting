package com.codingwithrufat.testing.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [UserEntity::class],
    version = 3,
    exportSchema = false
)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

}