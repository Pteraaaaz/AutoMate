package com.example.automate

data class Service(
    val id: Int,
    val name: String,
    val icon: Int,
    val isEmergency: Boolean = false
)
