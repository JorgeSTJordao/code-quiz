package com.masterjorge.codequiz.data.UserData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val username: String,
    val senha: String,
    val score: Int = 0
    )
