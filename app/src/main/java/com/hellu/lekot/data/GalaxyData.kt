package com.hellu.lekot.data

import com.hellu.lekot.R
import java.util.*


object GalaxyData {
    private val planetNames = arrayOf("Sun",
        "Mercury",
        "Venus",
        "Earth",
        "Mars",
        "Jupiter",
        "Saturn",
        "Uranus",
        "Neptune",
        "Pluto")

    private val planetDetail = arrayOf(
        "The Sun is by far the largest object in the solar system. It contains more than 99.8% of the total mass of the Solar System (Jupiter contains most of the rest).",
        "Mercury is the closest planet to the Sun but, perhaps surprisingly, it does not have the highest temperatures. It is the second densest planet of the Solar System, but also the smallest planet. The structure of Mercury makes it the most similar planet to Earth.",
        "Venus is the second planet from the Sun and the sixth-largest. Together with Mercury, they are the only planets without a satellite, even though Mercury is closer to the sun, Venus is the hottest planet.",
        "Earth is the third planet from the Sun and the fifth largest planet in the Solar System with the highest density. It is currently the only known location where life is present.",
        "Mars is the fourth planet from the Sun and the second-smallest planet with a thin atmosphere, having the surface features reminiscent both of the impact craters of the Moon, and the valleys, deserts and polar ice caps of Earth. It is the most widely searched planet for life.",
        "Jupiter is the fifth planet from the Sun and the largest planet of the Solar System. It is the oldest planet of the Solar System thus it was the first to take shape out of the remains of the solar nebula.",
        "Saturn is the sixth planet from the Sun, with the largest planetary rings in the Solar System. It is the second-largest planet after Jupiter, and recently, with many other moons being discovered, it surpassed the number of Jupiter’s moons and is now considered the planet with the most numerous satellites.",
        "Uranus is the seventh planet discovered in the Solar System that also led to the discovery of the last planet, Neptune they are both referred to as ice giants. Officially recognized in 1781 after many observations in the past, it is the third-largest planet of the Solar System.",
        "Neptune is the fourth largest and the farthest planet of the Solar System with the most powerful wind speeds out of all the planets. It is the smallest of the gas giants and is the first planet to be discovered by mathematical predictions in 1846.",
        "Pluto is the largest known dwarf planet in the Solar System, discovered in 1930. It was thought to be the 9th planet of our system for 75 years until the discovery of Eris and other similar objects that led to its demotion from a planet to a dwarf planet in 2006.")

    private val heroesImages = intArrayOf(
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

    val listData: ArrayList<Galaxy>
        get() {
            val list = arrayListOf<Galaxy>()
            for (position in planetNames.indices) {
                val planet = Galaxy()
                planet.planetName = planetNames[position]
                planet.planetDetail = planetDetail[position]
                planet.photo = heroesImages[position]
                list.add(planet)
            }
            return list
        }
}