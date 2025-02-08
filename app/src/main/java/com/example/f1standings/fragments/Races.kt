package com.example.f1standings.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.f1standings.R
import com.example.f1standings.api.races.RacesAdapter
import com.example.f1standings.models.races.Parameters
import com.example.f1standings.models.races.BaseModel
import com.example.f1standings.models.races.Circuit
import com.example.f1standings.models.races.Competition
import com.example.f1standings.models.races.Driver
import com.example.f1standings.models.races.FastestLap
import com.example.f1standings.models.races.Location
import com.example.f1standings.models.races.Response

class Races : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_races, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sampleData = getSampleData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.races_RecView)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RacesAdapter(sampleData)
        }
    }

    private fun getSampleData(): BaseModel {
        val sampleResponse = BaseModel(
            errors = emptyList(),
            get = "sample_get",
            parameters = Parameters("2024"),
            response = listOf(
                Response(
                    competition = Competition(1, Location("Monaco", "Monaco"), "Grand Prix de Monaco"),
                    date = "2022-05-29T12:00:00Z",
                    circuit = Circuit(1, "https://lebalap.academy/wp-content/uploads/2021/02/esquema-circuito-de-monaco.png", "Monaco"),
                    distance = "305.27 km",
                    fastestLap = FastestLap(Driver(1),"1:14.123")
                ),
                Response(
                    competition = Competition(2, Location("Monza", "Italy"), "Grand Prix de Italy"),
                    date = "2022-09-11T12:00:00Z",
                    circuit = Circuit(2, "https://lebalap.academy/wp-content/uploads/2021/02/image-6.png", "Monza"),
                    distance = "306.72 km",
                    fastestLap = FastestLap(Driver(2),"1:20.123")
                ),
                Response(
                    competition = Competition(3, Location("Suzuka", "Japan"), "Grand Prix de Japan"),
                    date = "2022-10-09T12:00:00Z",
                    circuit = Circuit(3, "https://lebalap.academy/wp-content/uploads/2021/02/image-7.png", "Suzuka"),
                    distance = "307.45 km",
                    fastestLap = FastestLap(Driver(3),"1:22.123")
                )
            )
        )
        return sampleResponse
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Races().apply {
                arguments = Bundle().apply {
                    putString("param1", param1)
                    putString("param2", param2)
                }
            }
    }
}
