package com.example.f1standings.api.drivers

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.f1standings.R
import com.example.f1standings.models.drivers.BaseModel
import com.example.f1standings.models.drivers.Response
import com.squareup.picasso.Picasso

class DriverStandingsAdapter(private val response: BaseModel) : RecyclerView.Adapter<DriverStandingsAdapter.DriverStandingsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverStandingsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.driver_card, parent, false)
        return DriverStandingsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DriverStandingsViewHolder, position: Int) {
        return holder.bindView(response.response[position])

    }

    override fun getItemCount(): Int {
        return response.response.size
    }

    class DriverStandingsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val driverPosition : TextView = itemView.findViewById(R.id.driver_position)
        private val driverImage : AppCompatImageView = itemView.findViewById(R.id.driver_image)
        private val driverName : TextView = itemView.findViewById(R.id.driver_name)
        private val driverTeam : TextView = itemView.findViewById(R.id.driver_team)
        private val driverPoints : TextView = itemView.findViewById(R.id.driver_points)

        @SuppressLint("SetTextI18n")
        fun bindView(response: Response) {
            driverPosition.text = response.position.toString()

            Picasso.get()
                .load(response.driver.image)
                .into(driverImage)

            driverName.text = response.driver.name
            driverTeam.text = response.team.name
            driverPoints.text = response.points.toString() + " pts"
        }
    }

}