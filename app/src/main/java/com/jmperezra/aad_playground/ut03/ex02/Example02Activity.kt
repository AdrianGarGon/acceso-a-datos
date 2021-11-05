package com.jmperezra.aad_playground.ut03.ex02

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jmperezra.aad_playground.R
import com.jmperezra.aad_playground.ut03.ex02.data.PersonDataRepository
import com.jmperezra.aad_playground.ut03.ex02.data.PersonLocalSource
import com.jmperezra.aad_playground.ut03.ex02.domain.PersonModel
import com.jmperezra.aad_playground.ut03.ex02.domain.PersonRepository
import com.jmperezra.aad_playground.ut03.ex02.domain.PetModel

/**
 * Ejemplo con Room y una relación 1:1.
 * Se harán inserciones, actualizaciones o borrados en la tabla 1:1
 */
class Example02Activity : AppCompatActivity() {

    private lateinit var repository: PersonRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example02)
        repository = PersonDataRepository(PersonLocalSource(applicationContext))
        executeQuery()
    }

    private fun executeQuery() {
        Thread {
            repository.savePerson(
                PersonModel(
                    1, "Pepe", 10, "Calle Mayor", PetModel(3, "Pepe", 1)
                )
            )
            val people = repository.fetchPeople()
            Log.d("@dev", "$people")
        }.start()
    }
}