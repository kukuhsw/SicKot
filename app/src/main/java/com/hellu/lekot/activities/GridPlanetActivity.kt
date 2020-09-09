package com.hellu.lekot.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hellu.lekot.R
import com.hellu.lekot.adapter.PlanetAdapter
import com.hellu.lekot.data.Planet
import com.hellu.lekot.extension.afterTextChanged
import com.hellu.lekot.extension.showToast
import com.hellu.lekot.utils.OnClickListener
import kotlinx.android.synthetic.main.activity_search_planet.*
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

class GridPlanetActivity : AppCompatActivity() {

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
        rvPlanet.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        planets = Planet.getPlanetList()
        myAdapter = PlanetAdapter()
        myAdapter.setData(planets)
        myAdapter.setListener(listener)
        rvPlanet.adapter = myAdapter
        myAdapter.notifyDataSetChanged()
    }

    private val listener = object : OnClickListener {
        override fun onClickEvent(planets: Planet) {
            sentDataPlanet(planets)
            showToast(planets.name, Toast.LENGTH_SHORT)
        }
    }

    private fun sentDataPlanet(planets: Planet) {
        val intent = Intent(this, DetailPlanetActivity::class.java)
        intent.putExtra("planet", planets as Serializable)
        startActivity(intent)
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