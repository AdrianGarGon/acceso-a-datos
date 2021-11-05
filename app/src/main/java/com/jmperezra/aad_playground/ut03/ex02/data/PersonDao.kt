package com.jmperezra.aad_playground.ut03.ex02.data

import androidx.room.*

@Dao
interface PersonDao {

    @Transaction
    @Query("SELECT * FROM person")
    fun findAll(): List<PersonAndPet>?

    @Query("SELECT * FROM person WHERE id = :personId")
    fun findById(personId: Int): PersonEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg personEntity: PersonEntity)

    @Insert
    fun insertPeopleAndPet(personEntity: PersonEntity, petEntity: PetEntity)

    @Delete
    fun delete(vararg personEntity: PersonEntity)

    @Update
    fun update(vararg personEntity: PersonEntity)

    @Transaction
    @Query("SELECT * FROM person")
    fun getUsersAndLibraries(): List<PersonAndPet>?
}