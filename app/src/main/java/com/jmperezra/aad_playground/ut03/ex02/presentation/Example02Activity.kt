package com.jmperezra.aad_playground.ut03.ex02.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jmperezra.aad_playground.R
import com.jmperezra.aad_playground.ut03.ex02.data.PersonDataRepository
import com.jmperezra.aad_playground.ut03.ex02.data.local.PersonLocalSource
import com.jmperezra.aad_playground.ut03.ex02.domain.*

/**
 * Ejemplo con Room y una relación 1:1.
 * Se harán inserciones, actualizaciones o borrados en la tabla 1:1
 */
class Example02Activity : AppCompatActivity() {

    private val repository: PersonRepository by lazy {
        PersonDataRepository(PersonLocalSource(applicationContext))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example02)
        executeQuery()
    }

    private fun executeQuery() {
        Thread {
            repository.savePerson(
                PersonModel(
                    1, "Pepe", 10, "Calle Mayor",
                    PetModel(3, "Pepe", 1),
                    mutableListOf(
                        CarModel(1, "Seat", "127"),
                        CarModel(2, "Ford", "Malaga")),
                    mutableListOf(
                        JobModel(1, "Teacher"),
                        JobModel(2, "Android Developer"))
                )
            )
            val people = repository.fetchPeople()
            Log.d("@dev", "$people")
        }.start()
    }
}