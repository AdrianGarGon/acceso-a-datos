package com.jmperezra.aad_playground.ut03.ex03.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface AlertDao {

    @Transaction
    @Query("SELECT * FROM alerts")
    fun findAll(): List<AlertAndFiles>

    @Transaction
    @Query("SELECT * FROM alerts WHERE id = :alertId")
    fun findById(alertId: String): AlertAndFiles?

    @Transaction
    @Query("SELECT * FROM alerts")
    fun getAlertAndFiles(): List<AlertAndFiles>

    @Insert
    fun insertAlertAndFiles(
        alertEntity: AlertEntity,
        fileEntities: List<FileEntity>
    )

    @Insert
    fun insert(alertEntity: AlertEntity, fileEntities: List<FileEntity>)
}