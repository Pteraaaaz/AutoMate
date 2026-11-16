package com.example.automate

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
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
        setupServices()

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


    private fun setupServices() {

        val services = listOf(

            Service(
                1,
                "Servis Rutin",
                R.drawable.ic_service_rutin
            ),

            Service(
                2,
                "Oli & Filter",
                R.drawable.ic_oil
            ),

            Service(
                3,
                "Rem & Ban",
                R.drawable.ic_brakes
            ),

            Service(
                4,
                "AC & Listrik",
                R.drawable.ic_ac
            ),

            Service(
                5,
                "Body & Cat",
                R.drawable.ic_body
            ),

            Service(
                6,
                "Tune Up",
                R.drawable.ic_tuneup
            ),

            Service(
                7,
                "Derek 24/7",
                R.drawable.ic_towing,
                isEmergency = true
            ),

            Service(
                8,
                "Tanya Montir",
                R.drawable.ic_mechanic
            )

        )

        val recyclerView = findViewById<RecyclerView>(
            R.id.rvServices
        )

        // Display 4 columns
        recyclerView.layoutManager = GridLayoutManager(
            this,
            4
        )

        recyclerView.adapter = ServiceAdapter(services) { service ->

            when (service.id) {

                1 -> startActivity(
                    Intent(this, WorkshopActivity::class.java)
                )

                2 -> startActivity(
                    Intent(this, WorkshopActivity::class.java)
                )

                3 -> startActivity(
                    Intent(this, WorkshopActivity::class.java)
                )

                4 -> startActivity(
                    Intent(this, WorkshopActivity::class.java)
                )

                5 -> startActivity(
                    Intent(this, WorkshopActivity::class.java)
                )

                6 -> startActivity(
                    Intent(this, WorkshopActivity::class.java)
                )

                7 -> startActivity(
                    Intent(this, WorkshopActivity::class.java)
                )

                8 -> startActivity(
                    Intent(this, WorkshopActivity::class.java)
                )
            }
        }

    }

}
