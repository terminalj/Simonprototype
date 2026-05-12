package com.example.simonprototype

import java.io.Serializable

//data class modified to be Serializable
data class Item(
    val number: Int,
    val index: Int,
    val text: String,
) : Serializable