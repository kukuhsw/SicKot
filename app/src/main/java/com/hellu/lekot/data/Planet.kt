package com.hellu.lekot.data

import com.hellu.lekot.R
import java.io.Serializable

/**
 * Created by Govind on 3/19/2018.
 */

class Planet(val name: String, val address: String, val photo: Int) : Serializable {

    companion object {

        private val planetImages = intArrayOf(
            R.drawable.sun,
            R.drawable.mercury,
            R.drawable.venus,
            R.drawable.earth,
            R.drawable.mars,
            R.drawable.jupiter,
            R.drawable.saturn,
            R.drawable.uranus,
            R.drawable.neptune,
            R.drawable.pluto
        )

        fun getPlanetList(): ArrayList<Planet> {
            val planets = ArrayList<Planet>()
            planets.clear()
            planets.add(Planet("Sun ", "Siliguri", planetImages[0]))
            planets.add(Planet("Mercury", "Jamshedpur",planetImages[1]))
            planets.add(Planet("Venus", "Haryana",planetImages[2]))
            planets.add(Planet("Earth", "Hubli",planetImages[3]))
            planets.add(Planet("Mars", "Karnataka",planetImages[4]))
            planets.add(Planet("Jupiter", "Bangalore",planetImages[5]))
            planets.add(Planet("Saturn", "New delhi",planetImages[6]))
            planets.add(Planet("Uranus", "Mangalore",planetImages[7]))
            planets.add(Planet("Neptune", "Ludhiana",planetImages[8]))
            planets.add(Planet("Pluto", "Tamil Nadu",planetImages[9]))
            return planets
        }
    }
}