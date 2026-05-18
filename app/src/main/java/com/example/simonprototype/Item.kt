package com.example.simonprototype

import java.io.Serializable

data class Item(
    val id: Long = 0,
    val number: Int,
    val index: Int,
    val text: String,
) : Serializable