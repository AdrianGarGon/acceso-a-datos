package com.jmperezra.aad_playground.ut03.ex01

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jmperezra.aad_playground.R
import com.jmperezra.aad_playground.ut03.ex01.data.Ex01Database
import com.jmperezra.aad_playground.ut03.ex01.data.UserEntity

class Example01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)
        exampleDB()
    }

    /**
     * Método para hacer un test sencillo en la base de datos.
     */
    private fun exampleDB() {
        val db = Ex01Database.getInstance(applicationContext)
        Thread {
            var user = db.userDao().findById(1)
            if (user == null) {
                db.userDao().insert(
                    UserEntity(1, "Alumno1", "alumno1", "alumno1@email.es"),
                    UserEntity(2, "Alumno2", "alumno2", "alumno2@email.es")
                )
                user = db.userDao().findById(1)
            }
            Log.d("@dev", "$user")
        }.start()
    }
}