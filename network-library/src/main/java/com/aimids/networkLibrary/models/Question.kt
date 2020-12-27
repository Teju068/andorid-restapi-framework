package com.aimids.networkLibrary.models

data class Question(
    val description: String,
    val options: List<Option>,
    val answer: Answer
)
