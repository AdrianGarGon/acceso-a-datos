package com.jmperezra.aad_playground.ut03.ex01.data

import androidx.room.*

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
    fun findById(id: Int): UserEntity?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(vararg user: UserEntity)

    @Delete
    fun delete(user: UserEntity)
}