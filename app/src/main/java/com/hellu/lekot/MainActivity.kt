package com.hellu.lekot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hellu.lekot.adapter.ListGalaxyAdapter
import com.hellu.lekot.data.Galaxy
import com.hellu.lekot.data.GalaxyData

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private var title = "List Galaxy"
    private val list = ArrayList<Galaxy>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(GalaxyData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListGalaxyAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListGalaxyAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Galaxy) {
                sentDataGalaxy(data)
                showSelectedHero(data)
            }
        })
    }

    private fun sentDataGalaxy(data: Galaxy) {
        val intent = Intent(this, DetailPlanetActivity::class.java)
        intent.putExtra("student", data)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == R.id.action_profile) {
            val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(moveIntent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    private fun showSelectedHero(galaxy: Galaxy) {
        Toast.makeText(this, "Kamu memilih " + galaxy.planetName, Toast.LENGTH_SHORT).show()
    }
}
