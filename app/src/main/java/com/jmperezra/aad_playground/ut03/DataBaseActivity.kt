package com.jmperezra.aad_playground.ut03

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.jmperezra.aad_playground.R
import com.jmperezra.aad_playground.ut03.data.AppDatabase
import com.jmperezra.aad_playground.ut03.data.UserEntity

class DataBaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)
        initDb()
    }

    private fun initDb() {
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database-name"
        ).build()

        Thread(Runnable {
            var user = db.userDao().findById(1)
            if (user == null) {
                db.userDao().insertAll(UserEntity(1, "Alumno1", "alumno1", "alumno@email.es"))
                user = db.userDao().findById(1)
            }
            Log.d("@dev", "$user")
        }).start()
    }
}