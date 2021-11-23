package com.jmperezra.aad_playground.ut03.ex03.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jmperezra.aad_playground.ut03.ex03.data.local.db.AlertDao
import com.jmperezra.aad_playground.ut03.ex03.data.local.db.AlertEntity
import com.jmperezra.aad_playground.ut03.ex03.data.local.db.FileEntity

@Database(
    entities = [AlertEntity::class, FileEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun alertDao(): AlertDao

    /**
     * Necesitamos crear una única instancia de la base de datos. Esto es así porque es muy
     * constoso en recursos de memoria usar varias instancias.
     *
     * A través del patrón de diseño SINGLETON creamos una instancia de la base de datos
     * y nos aseguramos que no se creen más.
     */
    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getInstance(applicationContext: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): AppDataBase {
            return Room.databaseBuilder(
                applicationContext,
                AppDataBase::class.java,
                "db-ut03-ex03"
            ).build()
        }
    }
}