package com.jmperezra.aad_playground.ut03.ex02.data

import androidx.room.*

@Dao
interface PetDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(vararg petEntity: PetEntity)



}