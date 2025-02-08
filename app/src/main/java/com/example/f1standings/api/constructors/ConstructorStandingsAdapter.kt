package com.example.f1standings.api.constructors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.f1standings.R
import com.example.f1standings.models.constructors.BaseModel
import com.example.f1standings.models.constructors.Response
import com.squareup.picasso.Picasso

class ConstructorStandingsAdapter(private val response: BaseModel) : RecyclerView.Adapter<ConstructorStandingsAdapter.ConstructorStandingsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ConstructorStandingsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.constructor_card, parent, false)
        return ConstructorStandingsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ConstructorStandingsViewHolder, position: Int) {
        return holder.bindView(response.response[position])
    }

    override fun getItemCount(): Int {
        return response.response.size
    }

    class ConstructorStandingsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val constructorPosition : TextView = itemView.findViewById(R.id.constructor_position)
        private val constructorImage : AppCompatImageView = itemView.findViewById(R.id.constructor_image)
        private val constructorName : TextView = itemView.findViewById(R.id.constructor_name)
        private val constructorPoints : TextView = itemView.findViewById(R.id.constructor_points)

        fun bindView(response: Response) {
            constructorPosition.text = response.position.toString()

            Picasso.get()
                .load(response.team.logo)
                .into(constructorImage)

            constructorName.text = response.team.name
            constructorPoints.text = response.points.toString()
        }
    }
}