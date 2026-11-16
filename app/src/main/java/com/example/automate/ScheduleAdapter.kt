package com.example.automate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.format.DateTimeFormatter

class ScheduleAdapter(
    private val schedules: List<Schedule>
) : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    class ScheduleViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val day = view.findViewById<TextView>(
            R.id.txtScheduleDay
        )

        val time = view.findViewById<TextView>(
            R.id.txtScheduleTime
        )

        val workshop = view.findViewById<TextView>(
            R.id.txtWorkshopName
        )

        val service = view.findViewById<TextView>(
            R.id.txtServiceName
        )

        val status = view.findViewById<TextView>(
            R.id.txtScheduleStatus
        )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScheduleViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_schedule, parent, false)

        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ScheduleViewHolder,
        position: Int
    ) {
        val schedule = schedules[position]

        holder.day.text = schedule.dateTime
            .format(DateTimeFormatter.ofPattern("dd MMM"))

        holder.time.text = schedule.dateTime
            .format(DateTimeFormatter.ofPattern("HH:mm"))

        holder.workshop.text = schedule.workshopName
        holder.service.text = schedule.serviceName
        holder.status.text = schedule.status
    }

    override fun getItemCount(): Int {
        return schedules.size
    }
}