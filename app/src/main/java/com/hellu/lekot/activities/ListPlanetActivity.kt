package com.hellu.lekot.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hellu.lekot.utils.OnClickListener
import com.hellu.lekot.R
import com.hellu.lekot.adapter.PlanetAdapter
import com.hellu.lekot.data.Planet
import com.hellu.lekot.extension.afterTextChanged
import com.hellu.lekot.extension.showToast
import kotlinx.android.synthetic.main.activity_search_planet.*
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList


class ListPlanetActivity : AppCompatActivity() {
    private lateinit var rvPlanet: RecyclerView

    private lateinit var myAdapter: PlanetAdapter
    private var users = ArrayList<Planet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_planet)

        supportActionBar?.let {
            it.title = "List Activity"
            it.setDisplayHomeAsUpEnabled(true)
        }

        myAdapter = PlanetAdapter()

        rvPlanet = findViewById(R.id.rv_planets)!!
        rvPlanet.setHasFixedSize(true)

        getUserList()

        editTextSearch.afterTextChanged { filter(it) }
    }

    private fun getUserList() {
        rvPlanet.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        users = Planet.getPlanetList()
        myAdapter = PlanetAdapter()
        myAdapter.setData(users)
        myAdapter.setListener(listener)
        rvPlanet.adapter = myAdapter
        myAdapter.notifyDataSetChanged()
    }

    private fun filter(text: String) {
        val filteredNames = ArrayList<Planet>()
        users.filterTo(filteredNames) {
            it.name.toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT))
        }
        myAdapter!!.filterList(filteredNames)
    }

    private val listener = object : OnClickListener {
        override fun onClickEvent(user: Planet) {
            sentDataPlanet(user)
            showToast(user.name, Toast.LENGTH_SHORT)
        }
    }

    private fun sentDataPlanet(data: Planet) {
        val intent = Intent(this, DetailPlanetActivity::class.java)
        intent.putExtra("planet", data as Serializable)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
