package com.codingwithrufat.testing.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface UserDao {

    @Query("SELECT * FROM USERS")
    fun getAllUsers(): Flow<List<UserEntity>>

    @Insert(onConflict = REPLACE)
    fun insertUser(userEntity: UserEntity)

    @Delete
    fun deleteUser(userEntity: UserEntity)

}