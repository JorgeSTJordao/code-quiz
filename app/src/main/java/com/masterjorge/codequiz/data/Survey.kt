package com.masterjorge.codequiz.data


data class Question(
    val image: Int,
    val description: String,
    val options: List<Option>,
)

data class Option(
    val text: String,
    val correct: Boolean,
    val score: Int = 0
)