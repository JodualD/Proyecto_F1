package com.example.f1standings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.example.f1standings.databinding.ActivityMainBinding
import com.example.f1standings.fragments.ConstructorsStandings
import com.example.f1standings.fragments.Home
import com.example.f1standings.fragments.Races
import com.example.f1standings.fragments.Standings

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)

        supportActionBar?.setCustomView(R.layout.toolbar_title_layout)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_home -> replaceFragment(Home())
                R.id.nav_standings -> replaceFragment(Standings())
                R.id.nav_races -> replaceFragment(Races())
                R.id.nav_teams -> replaceFragment(ConstructorsStandings())

                else -> {

                }
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_nav_wrapper, fragment)
        fragmentTransaction.commit()
    }
}