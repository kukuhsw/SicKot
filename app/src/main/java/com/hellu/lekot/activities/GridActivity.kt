package com.hellu.lekot.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hellu.lekot.R
import com.hellu.lekot.adapter.PlanetAdapter
import com.hellu.lekot.data.Planet

class GridActivity : AppCompatActivity() {

    private lateinit var rvPlanet: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)

        rvPlanet = findViewById(R.id.rv_grid_planets)!!
        rvPlanet.setHasFixedSize(true)

        displayStaggeredList()

    }

    private fun displayStaggeredList() {
        val staggered = ArrayList<Planet>()
        staggered.addAll(Planet.getPlanetList())
        rvPlanet.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvPlanet.adapter = PlanetAdapter(staggered)
    }
}