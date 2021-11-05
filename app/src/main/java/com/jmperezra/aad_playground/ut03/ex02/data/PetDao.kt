package com.jmperezra.aad_playground.ut03.ex02.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface PetDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg petEntity: PetEntity)
}