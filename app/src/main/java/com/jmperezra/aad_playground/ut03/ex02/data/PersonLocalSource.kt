package com.jmperezra.aad_playground.ut03.ex02.data.local

import android.content.Context
import com.jmperezra.aad_playground.ut03.ex02.data.*
import com.jmperezra.aad_playground.ut03.ex02.domain.PersonModel

class PersonLocalSource(applicationContext: Context) {

    private val db = Ut03Ex02DataBase.getInstance(applicationContext)

    init {
        /*
            Workaround (solución alterna)
            Para vaciar las tablas y esperar un tiempo para que le de tiempo a vaciarse.
         */
        Thread {
            db.clearAllTables()
        }.start()
        Thread.sleep(1000)
    }

    fun findAll(): List<PersonModel> {
        val personAndPetsAndCars = db.personDao().getPersonAndPetAndCarsAndJobs()
        return personAndPetsAndCars.map { element -> element.toModel() }
    }

    fun save(personModel: PersonModel) {
        db.personDao().insertPeopleAndPetAndCarsAndJobs(
            PersonEntity.toEntity(personModel),
            PetEntity.toEntity(personModel.petModel, personModel.id),
            CarEntity.toEntity(personModel.carModel, personModel.id),
            JobEntity.toEntity(personModel.jobModel),//Relación N:M
            PersonJobEntity.toEntity(personModel.id, personModel.jobModel.map { it.id }.toList())
        )
    }

    fun save2way(personModel: PersonModel) {
        db.runInTransaction {
            val personId = db.personDao().insert(PersonEntity.toEntity(personModel))
            db.petDao().insert(PetEntity.toEntity(personModel.petModel, personId.toInt()))
            db.carDao().insert(CarEntity.toEntity(personModel.carModel, personId.toInt()))
            val jobIds = db.jobDao().insert(JobEntity.toEntity(personModel.jobModel))
            db.personJobDao()
                .insert(PersonJobEntity.toEntity(personId.toInt(), jobIds.map { it.toInt() }))
        }
    }
}