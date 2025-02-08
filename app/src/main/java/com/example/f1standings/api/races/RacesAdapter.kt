package com.example.f1standings.api.races

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.f1standings.R
import com.example.f1standings.models.races.BaseModel
import com.example.f1standings.models.races.Response
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class RacesAdapter(private val response: BaseModel) : RecyclerView.Adapter<RacesAdapter.RacesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RacesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.race_card, parent, false)
        return RacesViewHolder(itemView)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RacesViewHolder, position: Int) {
        return holder.bindView(response.response[position])
    }

    override fun getItemCount(): Int {
        return response.response.size
    }

    class RacesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val raceName : TextView = itemView.findViewById(R.id.race_name)
        private val raceDate : TextView = itemView.findViewById(R.id.race_date)
        private val raceCircuit: TextView = itemView.findViewById(R.id.race_circuit)
        private val raceImage : AppCompatImageView = itemView.findViewById(R.id.race_image)
        private val raceDistance : TextView = itemView.findViewById(R.id.race_total_distance)
        private val raceLapTime : TextView = itemView.findViewById(R.id.race_lap_time)

        @RequiresApi(Build.VERSION_CODES.O)
        @SuppressLint("SimpleDateFormat")
        fun bindView(response: Response) {
            raceName.text = response.competition.name

            val parsedDate = LocalDateTime.parse(response.date, DateTimeFormatter.ISO_DATE_TIME)
            val formattedDate = parsedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))
            raceDate.text = formattedDate

            raceCircuit.text = response.circuit.name

            Picasso.get()
                .load(response.circuit.image)
                .into(raceImage)

            raceDistance.text = response.distance
            raceLapTime.text = response.fastestLap.time
        }
    }
}
