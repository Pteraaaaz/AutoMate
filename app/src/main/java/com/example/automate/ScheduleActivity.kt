package com.example.automate

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime

class ScheduleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_schedule)

        val recyclerView = findViewById<RecyclerView>(
            R.id.rvAllSchedules
        )

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        val upcomingSchedules = ScheduleRepository.schedules
            .filter {
                it.dateTime.isAfter(LocalDateTime.now())
            }
            .sortedBy { it.dateTime }

        recyclerView.adapter = ScheduleAdapter(upcomingSchedules)

        val backBtn = findViewById<Button>(R.id.backBtn)
        backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}