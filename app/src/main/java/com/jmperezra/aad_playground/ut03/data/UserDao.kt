package com.jmperezra.aad_playground.ut03.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UserEntity>

    @Query(
        "SELECT * FROM user WHERE name LIKE :first AND " +
                "username LIKE :last LIMIT 1"
    )
    fun findByName(first: String, last: String): UserEntity

    @Query("SELECT * from user WHERE id = :id")
    fun findById(id: Int): UserEntity

    @Insert
    fun insertAll(vararg user: UserEntity)

    @Delete
    fun delete(user: UserEntity)
}