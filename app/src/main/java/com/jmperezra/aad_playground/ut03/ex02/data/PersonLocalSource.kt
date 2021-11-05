package com.jmperezra.aad_playground.ut03.ex02.data

import android.content.Context
import com.jmperezra.aad_playground.ut03.ex02.domain.PersonModel

class PersonLocalSource(applicationContext: Context) {

    private val db = Ut03Ex02Database.getInstance(applicationContext)

    init {
        Thread {
            db.clearAllTables()
            Thread.sleep(1000)
        }.start()
    }

    fun findAll(): List<PersonModel> {
        val people = db.personDao().getUsersAndLibraries()
        return if (people == null) {
            mutableListOf()
        } else {
            mutableListOf()
        }
    }

    fun save(personModel: PersonModel) {
        db.personDao().insertPeopleAndPet(
            PersonEntity(personModel.id, personModel.name, personModel.age),
            PetEntity(
                personModel.petModel.id,
                personModel.petModel.name,
                personModel.id
            )
        )
    }
}