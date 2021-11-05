package com.jmperezra.aad_playground.ut03.ex02.domain

interface PersonRepository {

    /**
     * Obtiene un listado de personas.
     */
    fun fetchPeople(): List<PersonModel>

    /**
     * Guarda un modelo Person
     */
    fun savePerson(person: PersonModel)
}