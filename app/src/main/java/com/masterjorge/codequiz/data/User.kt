package com.masterjorge.codequiz.data

data class User(
    val id: Int,
    val username: String,
    val senha: Int,
    var score: Int = 0
)
