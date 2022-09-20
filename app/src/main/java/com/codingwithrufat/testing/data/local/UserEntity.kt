package com.codingwithrufat.testing.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "USERS")
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val username: String,
    val surname: String
)