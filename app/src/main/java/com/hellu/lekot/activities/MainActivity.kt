package com.hellu.lekot.activities

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hellu.lekot.R
import com.hellu.lekot.adapter.HomeAdapter
import com.hellu.lekot.data.Planet
import com.hellu.lekot.utils.OnClickListener
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable


class MainActivity : AppCompatActivity() {

    private lateinit var rvPlanet: RecyclerView

    private var myAdapter: HomeAdapter? = null
    private var users = ArrayList<Planet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPlanet = findViewById(R.id.rv_planets)!!
        rvPlanet.setHasFixedSize(true)

        openListPlanet(btnFilter)
        openGridPlanet(btnGrid)

        displayListHorizontal()

    }

    private fun displayListHorizontal() {
        rvPlanet.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        users = Planet.getPlanetList()
        myAdapter = HomeAdapter(users)
        myAdapter!!.setListener(listener)
        rvPlanet.adapter = myAdapter
    }

    private fun openGridPlanet(btnGrid: CardView?) {
        if (btnGrid != null) {
            btnGrid.setOnClickListener {
                val intent = Intent(this, GridPlanetActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun openListPlanet(btnFilter: CardView?) {
        if (btnFilter != null) {
            btnFilter.setOnClickListener {
                val intent = Intent(this, ListPlanetActivity::class.java)
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


    private val listener = object : OnClickListener {
        override fun onClickEvent(user: Planet) {
            sentDataPlanet(user)
        }
    }

    private fun sentDataPlanet(data: Planet) {
        val intent = Intent(this, DetailPlanetActivity::class.java)
        intent.putExtra("planet", data as Serializable)
        startActivity(intent)
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setIcon(R.drawable.alert_box_outline)
            .setTitle("Keluar Apps")
            .setMessage("Benar mau keluar Apps?")
            .setPositiveButton("Iya",
                DialogInterface.OnClickListener { dialog, which -> finish() })
            .setNegativeButton("Tidak", null)
            .show()
    }

}
