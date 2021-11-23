package com.jmperezra.aad_playground.ut03.ex02.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.jmperezra.aad_playground.ut03.ex02.data.CarEntity
import com.jmperezra.aad_playground.ut03.ex02.data.PersonAndPet

@Dao
interface CarDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert( carEntity: List<CarEntity>): List<Long>

}