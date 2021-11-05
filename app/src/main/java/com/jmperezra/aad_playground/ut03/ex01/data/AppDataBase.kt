package com.jmperezra.aad_playground.ut03.ex01.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class Ex01Database : RoomDatabase() {
    abstract fun userDao(): UserDao


    /**
     * Necesitamos crear una única instancia de la base de datos. Esto es así porque es muy
     * constoso en recursos de memoria usar varias instancias.
     *
     * A través del patrón de diseño SINGLETON creamos una instancia de la base de datos
     * y nos aseguramos que no se creen más.
     */
    companion object {
        @Volatile
        private var instance: Ex01Database? = null

        fun getInstance(applicationContext: Context): Ex01Database {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): Ex01Database {
            return Room.databaseBuilder(
                applicationContext,
                Ex01Database::class.java,
                "db-ex01"
            ).build()
        }
    }
}