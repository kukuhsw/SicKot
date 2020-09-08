package com.hellu.lekot.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hellu.lekot.R
import com.hellu.lekot.adapter.PlanetAdapter
import com.hellu.lekot.data.Planet
import com.hellu.lekot.extension.afterTextChanged
import kotlinx.android.synthetic.main.activity_search_planet.*
import java.util.*
import kotlin.collections.ArrayList

class GridActivity : AppCompatActivity() {

    private lateinit var myAdapter: PlanetAdapter
    private var planets = ArrayList<Planet>()
    private lateinit var rvPlanet: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        supportActionBar?.let {
            it.title = "Grid Activity"
            it.setDisplayHomeAsUpEnabled(true)
        }

        rvPlanet = findViewById(R.id.rv_grid_planets)!!
        rvPlanet.setHasFixedSize(true)

        myAdapter = PlanetAdapter()
        displayStaggeredList()
        editTextSearch.afterTextChanged { filter(it) }

    }

    private fun displayStaggeredList() {
        rvPlanet.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        planets = Planet.getPlanetList()
        myAdapter = PlanetAdapter()
        myAdapter.setData(planets)
        rvPlanet.adapter = myAdapter
        myAdapter.notifyDataSetChanged()
    }

    private fun filter(text: String) {
        val filteredNames = ArrayList<Planet>()
        planets.filterTo(filteredNames) {
            it.name.toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT))
        }
        myAdapter!!.filterList(filteredNames)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}