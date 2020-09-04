package com.hellu.lekot.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hellu.lekot.OnClickListener
import com.hellu.lekot.R
import com.hellu.lekot.adapter.PlanetAdapter
import com.hellu.lekot.data.Planet
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var rvPlanet: RecyclerView

//    add
    private var myAdapter: PlanetAdapter? = null
    private var users = ArrayList<Planet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.let {
            it.title = "Home"
            it.setDisplayHomeAsUpEnabled(true)
        }

        rvPlanet = findViewById(R.id.rv_heroes)
        rvPlanet.setHasFixedSize(true)

        getUserList()

        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun afterTextChanged(editable: Editable) {
                filter(editable.toString())
            }
        })
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

    private fun getUserList() {
        rvPlanet.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        users = Planet.getPlanetList()
        myAdapter = PlanetAdapter(users)
        myAdapter!!.setListener(listener)
        rvPlanet.adapter = myAdapter
    }

    private fun filter(text: String) {
        val filteredNames = ArrayList<Planet>()
        users.filterTo(filteredNames) {
            it.name.toLowerCase().contains(text.toLowerCase())
        }
        myAdapter!!.filterList(filteredNames)
    }

    private val listener = object : OnClickListener {
        override fun onClickEvent(user: Planet) {
            sentDataPlanet(user)
            Toast.makeText(applicationContext, user.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun sentDataPlanet(data: Planet) {
        val intent = Intent(this, DetailPlanetActivity::class.java)
        intent.putExtra("planet", data as Serializable)
        startActivity(intent)
    }

}
