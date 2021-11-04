package com.jmperezra.aad_playground.ut02.exercise01

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jmperezra.aad_playground.R
import com.jmperezra.aad_playground.ut02.MemDataSource
import com.jmperezra.aad_playground.ut02.SharPrefDataSource
import com.jmperezra.aad_playground.ut02.UserModel
import com.jmperezra.aad_playground.ut02.exercise01.repository.LocalDataSource
import com.jmperezra.aad_playground.ut02.exercise01.repository.UserRepository

class Exercise01Activity : AppCompatActivity() {

    private val TAG = Exercise01Activity::class.java.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
        initExample01()
        initExample02()
        initExample03()
    }

    private fun initExample01() {
        val localDataSource = LocalDataSource(this)
        localDataSource.saveAsync("1", "Hola1")
        val data = localDataSource.read("1")
        Log.d(TAG, data!!)
    }

    private fun initExample02() {
        val localDataSource = LocalDataSource(this)
        localDataSource.saveAsyncEncrypt("1", "Hola1")
        val data = localDataSource.readEncrypt("1")
        Log.d(TAG, data!!)
    }

    private fun initExample03() {
        val userRepository =
            UserRepository(MemDataSource(), SharPrefDataSource(this))

        val userModel1 = UserModel(1, "User1", "Surname1")
        val userModel2 = UserModel(2, "User2", "Surname2")
        val userModel3 = UserModel(3, "User3", "Surname3")

        //Guardo los usuarios ¿Dónde? en esta clase no se preocupa de eso, no tiene esa responsabilidad.
        userRepository.saveUsers(mutableListOf(userModel1, userModel2, userModel3))

        //Obtengo todos los resultados. ¿Desde donde?. No es responsabilidad de esta clase.
        val users = userRepository.fetchAllUsers()

        //Busco un usuario. ¿Cómo lo he hecho? No es responsabilidad de la vista.
        val user = userRepository.fetchUser(1)

    }
}