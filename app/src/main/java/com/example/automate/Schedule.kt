package com.example.automate

import java.time.LocalDateTime

data class Schedule(
    val id: Int,
    val workshopName: String,
    val serviceName: String,
    val dateTime: LocalDateTime,
    val status: String
)
