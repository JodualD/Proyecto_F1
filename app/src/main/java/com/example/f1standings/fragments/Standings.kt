package com.example.f1standings.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.f1standings.R
import com.example.f1standings.api.drivers.DriverStandingsAdapter
import com.example.f1standings.models.drivers.BaseModel
import com.example.f1standings.models.drivers.Response
import com.example.f1standings.models.drivers.Driver
import com.example.f1standings.models.drivers.Parameters
import com.example.f1standings.models.drivers.Team
import java.lang.reflect.Parameter

class Standings : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_standings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val driverStandings = getSampleData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.driverStandings_RecView)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DriverStandingsAdapter(driverStandings)
        }
    }

    private fun getSampleData(): BaseModel {
        val sampleResponse = BaseModel(
            errors = emptyList(),
            get = "sample_get",
            parameters = Parameters("2024"),
            response = listOf(
                Response(
                    behind = null,
                    Driver("HAM", 1, "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/868.png", "Lewis Hamilton", 44),
                    250,
                    1,
                    2024,
                    Team(1, "https://brandlogos.net/wp-content/uploads/2022/07/mercedes-amg_petronas_f1-logo_brandlogos.net_lq7eb.png", "Mercedes"),
                    10
                ),
                Response(
                    behind = 10,
                    Driver("VER", 2, "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/4665.png", "Max Verstappen", 33),
                    150,
                    2,
                    2024,
                    Team(2, "https://cdn-6.motorsport.com/images/mgl/Y99JQRbY/s8/red-bull-racing-logo-1.jpg", "Red Bull Racing"),
                    9
                ),
                Response(
                    behind = 20,
                    Driver("NOR", 3, "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5579.png", "Lando Norris", 4),
                    50,
                    3,
                    2024,
                    Team(3, "https://brandlogos.net/wp-content/uploads/2022/04/mclaren_formula_1_team-logo-brandlogos.net_.png", "McLaren"),
                    8
                ),
                Response(
                    behind = 30,
                    Driver("LEC", 4, "https://a.espncdn.com/combiner/i?img=/i/headshots/rpm/players/full/5498.png&w=350&h=254", "Charles Leclerc", 16),
                    10,
                    4,
                    2024,
                    Team(4, "https://static.wikia.nocookie.net/f1wikia/images/d/d6/FerrariLogo.png/revision/latest?cb=20220216092511", "Ferrari"),
                    7
                )
            ),
            results = 4
        )
        return sampleResponse
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Standings().apply {
                arguments = Bundle().apply {
                    putString("param1", param1)
                    putString("param2", param2)
                }
            }
    }
}
