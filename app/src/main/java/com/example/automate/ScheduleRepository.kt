package com.example.automate

import java.time.LocalDateTime

object ScheduleRepository {

    val schedules = listOf(

        Schedule(
            1,
            "MasterTune BSD",
            "Tune Up Injeksi & Spooring 3D",
            LocalDateTime.of(2026, 11, 17, 9, 30),
            "Terkonfirmasi"
        ),

        Schedule(
            2,
            "AutoCare Tangerang",
            "Ganti Oli",
            LocalDateTime.of(2026, 11, 20, 14, 0),
            "Menunggu"
        ),

        Schedule(
            3,
            "Honda Service Center",
            "Pemeriksaan Mesin",
            LocalDateTime.of(2026, 11, 25, 10, 0),
            "Terkonfirmasi"
        )
    )
}