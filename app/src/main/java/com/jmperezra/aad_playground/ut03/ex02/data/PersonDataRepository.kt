package com.jmperezra.aad_playground.ut03.ex02.data

import com.jmperezra.aad_playground.ut03.ex02.domain.PersonModel
import com.jmperezra.aad_playground.ut03.ex02.domain.PersonRepository

class PersonDataRepository(private val personLocalSource: PersonLocalSource) : PersonRepository {

    override fun fetchPeople(): List<PersonModel> {
        return personLocalSource.findAll()
    }

    override fun savePerson(person: PersonModel) {
        personLocalSource.save(person)
    }
}