package com.hellu.lekot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                showSelectedHero(data)
            }
        })
    }

//    private fun showRecyclerGrid() {
//        rvHeroes.layoutManager = GridLayoutManager(this, 2)
//        val gridHeroAdapter = GridHeroAdapter(list)
//        rvHeroes.adapter = gridHeroAdapter
//
//        gridHeroAdapter.setOnItemClickCallback(object : GridHeroAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: Hero) {
//                showSelectedHero(data)
//            }
//        })
//    }

//    private fun showRecyclerCardView() {
//        rvHeroes.layoutManager = LinearLayoutManager(this)
//        val cardViewHeroAdapter = CardViewHeroAdapter(list)
//        rvHeroes.adapter = cardViewHeroAdapter
//    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        setMode(item.itemId)
//        return super.onOptionsItemSelected(item)
//    }

//    private fun setMode(selectedMode: Int) {
//        when (selectedMode) {
//            R.id.action_list -> {
//                title = "Mode List"
//                showRecyclerList()
//            }
//
//            R.id.action_grid -> {
//                title = "Mode Grid"
////                showRecyclerGrid()
//            }
//
//            R.id.action_cardview -> {
//                title = "Mode CardView"
////                showRecyclerCardView()
//            }
//        }
//        setActionBarTitle(title)
//    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    private fun showSelectedHero(galaxy: Galaxy) {
        Toast.makeText(this, "Kamu memilih " + galaxy.planetName, Toast.LENGTH_SHORT).show()
    }

}
