package com.example.f1standings.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.f1standings.R
import com.example.f1standings.api.constructors.ConstructorStandingsAdapter
import com.example.f1standings.models.constructors.BaseModel
import com.example.f1standings.models.constructors.Parameters
import com.example.f1standings.models.constructors.Response
import com.example.f1standings.models.constructors.Team

class ConstructorsStandings : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_constructors_standings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sampleData = getSampleData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.constructorStandings_RecView)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ConstructorStandingsAdapter(sampleData)
        }
    }

    private fun getSampleData(): BaseModel {
        val sampleResponse = BaseModel(
            errors = emptyList(),
            get = "sample_get",
            parameters = Parameters("2024"),
            response = listOf(
                Response(
                    points = 100,
                    position = 1,
                    season = 2024,
                    team = Team(1, "https://static.wikia.nocookie.net/f1wikia/images/d/d6/FerrariLogo.png/revision/latest?cb=20220216092511", "Team Ferrari")
                ),
                Response(
                    points = 90,
                    position = 2,
                    season = 2024,
                    team = Team(2, "https://brandlogos.net/wp-content/uploads/2022/07/mercedes-amg_petronas_f1-logo_brandlogos.net_lq7eb.png", "Team Mercedes")
                ),
                Response(
                    points = 80,
                    position = 3,
                    season = 2024,
                    team = Team(3, "https://cdn-6.motorsport.com/images/mgl/Y99JQRbY/s8/red-bull-racing-logo-1.jpg", "Team Red Bull Racing")
                ),
                Response(
                    points = 70,
                    position = 4,
                    season = 2024,
                    team = Team(4, "https://brandlogos.net/wp-content/uploads/2022/04/mclaren_formula_1_team-logo-brandlogos.net_.png", "Team McLaren")
                ),
                Response(
                    points = 60,
                    position = 5,
                    season = 2024,
                    team = Team(5, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Alpine_F1_Team_Logo.svg/2233px-Alpine_F1_Team_Logo.svg.png", "Team Alpine")
                )
            ),
            results = 5
        )
        return sampleResponse
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ConstructorsStandings().apply {
                arguments = Bundle().apply {
                    putString("param1", param1)
                    putString("param2", param2)
                }
            }
    }
}
