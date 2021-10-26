package com.jmperezra.aad_playground.ut03.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(ignoredColumns = arrayOf("email"))
//@Entity(indices = arrayOf(Index(value = ["name", "username"])))
@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "email") val email: String?
)