package com.example.automate

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        enableEdgeToEdge()

        // Load XML layout
        setContentView(R.layout.activity_main)

        // Handle system bars (status bar and navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v, insets ->

            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // Initialize upcoming schedule section
        setupUpcomingSchedule()

    }

    private fun setupUpcomingSchedule() {

        // Get all schedules
        val upcomingSchedules = ScheduleRepository.schedules
            .filter {
                it.dateTime.isAfter(LocalDateTime.now())
            }
            .sortedBy {
                it.dateTime
            }

        // Get the most urgent schedule
        val nearestSchedule = upcomingSchedules.firstOrNull()

        // Find RecyclerView
        val recyclerView = findViewById<RecyclerView>(
            R.id.rvUpcomingSchedule
        )

        // Configure RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Display only the nearest schedule
        recyclerView.adapter = ScheduleAdapter(
            nearestSchedule?.let {
                listOf(it)
            } ?: emptyList()
        )

        // Handle Rincian button
        val detailsButton = findViewById<TextView>(
            R.id.btnScheduleDetails
        )

        detailsButton.setOnClickListener {

            val intent = Intent(
                this,
                ScheduleActivity::class.java
            )

            startActivity(intent)
        }
    }
}
