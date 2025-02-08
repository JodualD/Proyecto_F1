package com.example.f1standings.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.f1standings.R
import com.example.f1standings.api.drivers.DriverStandingsAdapter
import com.example.f1standings.api.drivers.DriverStandingsApiService
import com.example.f1standings.api.drivers.DriverStandingsServiceGenerator
import com.example.f1standings.models.drivers.BaseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Standings.newInstance] factory method to
 * create an instance of this fragment.
 */
class Standings : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_standings, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val driverServiceGenerator = DriverStandingsServiceGenerator.buildService(DriverStandingsApiService::class.java)
        val call = driverServiceGenerator.getDriverStandings()
        val recyclerView = getView()?.findViewById<RecyclerView>(R.id.driverStandings_RecView)

        call.enqueue(object: Callback<BaseModel> {
            override fun onResponse(
                call: Call<BaseModel>,
                response: retrofit2.Response<BaseModel>
            ) {
                if(response.isSuccessful) {
                        Log.e("success", response.body().toString())
                    recyclerView?.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = DriverStandingsAdapter(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<BaseModel>, t: Throwable) {
                t.printStackTrace()
                Log.e("error",t.message.toString())
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Standings.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Standings().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}