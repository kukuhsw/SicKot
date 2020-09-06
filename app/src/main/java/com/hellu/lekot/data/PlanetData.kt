package com.hellu.lekot.data

import com.hellu.lekot.R
import java.io.Serializable

data class PlanetData(val viewType: Int, val name: String, val address: String, val photo: Int, val surfaceTemp:Int, val age:Double, val diameter:Int, val mass:Int):Serializable{

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

        fun getPlanetList(): ArrayList<PlanetData> {
            val planets = ArrayList<PlanetData>()
            planets.clear()
            planets.add(PlanetData(2,"Sun","Sun is bla bla bla", planetImages[0],45,45.7,56,99))
            planets.add(PlanetData(2,"Sun","Sun is bla bla bla", planetImages[0],45,45.7,56,99))
            planets.add(PlanetData(2,"Sun","Sun is bla bla bla", planetImages[0],45,45.7,56,99))
            planets.add(PlanetData(2,"Sun","Sun is bla bla bla", planetImages[0],45,45.7,56,99))
            planets.add(PlanetData(2,"Sun","Sun is bla bla bla", planetImages[0],45,45.7,56,99))
            planets.add(PlanetData(2,"Sun","Sun is bla bla bla", planetImages[0],45,45.7,56,99))
            planets.add(PlanetData(2,"Sun","Sun is bla bla bla", planetImages[0],45,45.7,56,99))
            planets.add(PlanetData(2,"Sun","Sun is bla bla bla", planetImages[0],45,45.7,56,99))
            planets.add(PlanetData(2,"Sun","Sun is bla bla bla", planetImages[0],45,45.7,56,99))
            planets.add(PlanetData(2,"Sun","Sun is bla bla bla", planetImages[0],45,45.7,56,99))
            planets.add(PlanetData(2,"Sun","Sun is bla bla bla", planetImages[0],45,45.7,56,99))
            planets.add(PlanetData(2,"Sun","Sun is bla bla bla", planetImages[0],45,45.7,56,99))
          return planets
        }


    }

}



