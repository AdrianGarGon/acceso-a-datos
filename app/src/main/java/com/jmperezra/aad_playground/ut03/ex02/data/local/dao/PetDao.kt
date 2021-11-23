package com.jmperezra.aad_playground.ut03.ex02.data.local.dao

import androidx.room.*
import com.jmperezra.aad_playground.ut03.ex02.data.PetEntity

@Dao
interface PetDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(vararg petEntity: PetEntity)



}