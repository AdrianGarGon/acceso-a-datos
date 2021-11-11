package com.jmperezra.aad_playground.ut03.ex02.data

import android.content.Context
import com.jmperezra.aad_playground.ut03.ex02.app.Ut03Ex02DataBase
import com.jmperezra.aad_playground.ut03.ex02.domain.PersonModel

class PersonLocalSource(applicationContext: Context) {

    private val db = Ut03Ex02DataBase.getInstance(applicationContext)

    init {
        Thread {
            db.clearAllTables()
            Thread.sleep(1000)
        }.start()
    }

    fun findAll(): List<PersonModel> {
        val personAndPets = db.personDao().getPersonAndPets()
        return personAndPets?.map { element -> element.toModel() } ?: mutableListOf()
    }

    fun save(personalModel: PersonModel) {
        db.personDao().insertPeopleAndPet(
            PersonEntity(
                personalModel.id,
                personalModel.name,
                personalModel.age
            ),
            PetEntity(
                personalModel.petModel.id,
                personalModel.petModel.name,
                personalModel.petModel.age,
                personalModel.id
            )

        )
    }
/*
    fun saveWithoutId(personalModel: PersonModel) {
        val personId =
            db.personDao().insert(PersonEntity(name = personalModel.name, age = personalModel.age))
        db.petDao().insert(
            PetEntity(
                name = personalModel.petModel.name,
                age = personalModel.petModel.age,
                personId = personId.toInt()
            )
        )
    }
    */


}


