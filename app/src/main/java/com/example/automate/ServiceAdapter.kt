package com.example.automate

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView




class ServiceAdapter(
    private val services: List<Service>,
    private val onServiceClick: (Service) -> Unit
) : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    class ServiceViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val card = view.findViewById<CardView>(
            R.id.serviceCard
        )

        val iconContainer = view.findViewById<FrameLayout>(
            R.id.iconContainer
        )

        val icon = view.findViewById<ImageView>(
            R.id.imgServiceIcon
        )

        val name = view.findViewById<TextView>(
            R.id.txtServiceName
        )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ServiceViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_service, parent, false)

        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ServiceViewHolder,
        position: Int
    ) {

        val service = services[position]

        holder.name.text = service.name
        holder.icon.setImageResource(service.icon)

        // Special styling for emergency service
        if (service.isEmergency) {

            holder.card.setCardBackgroundColor(
                Color.parseColor("#FFDAD7")
            )

            holder.iconContainer.backgroundTintList =
                ColorStateList.valueOf(
                    Color.parseColor("#C51E20")
                )

            holder.icon.imageTintList =
                ColorStateList.valueOf(Color.WHITE)

            holder.name.setTextColor(
                Color.parseColor("#B91C1C")
            )

        } else {

            holder.card.setCardBackgroundColor(Color.WHITE)

            holder.iconContainer.backgroundTintList =
                ColorStateList.valueOf(
                    Color.parseColor("#E6EEFF")
                )

            holder.icon.imageTintList =
                ColorStateList.valueOf(
                    Color.parseColor("#B84B0A")
                )

            holder.name.setTextColor(
                Color.parseColor("#17253B")
            )
        }

        // Handle clicks
        holder.card.setOnClickListener {
            onServiceClick(service)
        }
    }

    override fun getItemCount(): Int {
        return services.size
    }
}


