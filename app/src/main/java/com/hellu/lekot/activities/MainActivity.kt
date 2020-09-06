package com.hellu.lekot.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hellu.lekot.OnClickListener
import com.hellu.lekot.R
import com.hellu.lekot.adapter.PlanetAdapter
import com.hellu.lekot.adapter.RecyclerViewAdapter
import com.hellu.lekot.data.Planet
import com.hellu.lekot.data.PlanetData
import com.hellu.lekot.extension.showToast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var rvPlanet: RecyclerView
    private lateinit var rvLargePlanet: RecyclerView

//    add
    private var myAdapter: PlanetAdapter? = null
    private var users = ArrayList<Planet>()

    //    add
    private var planetAdapter: RecyclerViewAdapter? = null
    private var planets = ArrayList<PlanetData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.let {
            it.title = "Home"
        }

        rvPlanet = findViewById(R.id.rv_planets)
        rvPlanet.setHasFixedSize(true)

        rvLargePlanet = findViewById(R.id.rv_LargePlanet)
        rvLargePlanet.setHasFixedSize(true)

        openListPlanet(btnFilter)
        openGridPlanet(btnGrid)

//        getUserList()
        showPlanetList()

    }

    private fun showPlanetList() {
        planets = PlanetData.getPlanetList()
        val adapter = RecyclerViewAdapter(this, planets)
        rvLargePlanet.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvLargePlanet.adapter = adapter
    }

    private fun openGridPlanet(btnGrid: CardView?) {
        if (btnGrid != null) {
            btnGrid.setOnClickListener {
                val intent = Intent(this, SearchPlanetActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun openListPlanet(btnFilter: CardView?) {
        if (btnFilter != null) {
            btnFilter.setOnClickListener {
                val intent = Intent(this, SearchPlanetActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_profile) {
            val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(moveIntent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getUserList() {
        rvPlanet.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        users = Planet.getPlanetList()
        myAdapter = PlanetAdapter(users)
        myAdapter!!.setListener(listener)
        rvPlanet.adapter = myAdapter
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


}
