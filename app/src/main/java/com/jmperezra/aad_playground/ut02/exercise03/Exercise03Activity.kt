package com.jmperezra.aad_playground.ut02.exercise03

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jmperezra.aad_playground.R
import com.jmperezra.aad_playground.commons.GsonSerializer
import com.jmperezra.aad_playground.ut02.exercise03.data.AppLocalModel
import com.jmperezra.aad_playground.ut02.exercise03.data.AppRepository
import com.jmperezra.aad_playground.ut02.exercise03.data.SharPrefLocalStorage

/**
 * El ejercicio lleva un README.md con la información detallada de lo que se pide.
 * Ten presente los objetivos que se trabajan para la resolución de la tarea.
 */
class Exercise03Activity : AppCompatActivity() {

    private val TAG = Exercise03Activity::class.java.simpleName
    private lateinit var appRatingBar: RatingBar
    private lateinit var appRepository: AppRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise03)
        appRepository = AppRepository(SharPrefLocalStorage(this, GsonSerializer()))
        setupView()
        isFirstTime()
        updateRatingValue()
    }

    private fun setupView() {
        findViewById<Button>(R.id.action_reset).setOnClickListener {
            actionResetClicked()
        }
        appRatingBar = findViewById(R.id.action_rating)
        appRatingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            kotlin.run {
                if (fromUser) {
                    onChangeRating(rating)
                }
            }
        }
    }

    /**
     * Método que me indica TRUE si es la primera vez que abro la aplicación o FALSE si ya la
     * he abierto más de una vez. Si la aplicación se cierra, debe seguir conservando la información.
     */
    private fun isFirstTime() {
        val appModel = appRepository.fetch()
        if (appModel == null || appModel.isFirstTime) {
            appRepository.save(AppLocalModel(false))
            Toast.makeText(this, R.string.label_is_first_time, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, R.string.label_is_not_first_time, Toast.LENGTH_LONG).show()
        }
    }


    /**
     * Método que se ejecuta cada vez que se pulsa el botón reset
     * Debería reiniciar las estrellas a 0.
     */
    private fun actionResetClicked() {
        val appModel = appRepository.fetch()
        if (appModel != null) {
            val resetValue = 0f
            appRepository.save(AppLocalModel(appModel.isFirstTime, resetValue))
            setRatingValue(resetValue)
        }
    }

    /**
     * Método que se ejecuta cuando el usuario cambia el valor del rating
     * En este método debemos almacenar el valor
     */
    private fun onChangeRating(newValue: Float) {
        Log.d(TAG, "El usuario está cambiando el valor: ${newValue.toString()}")
        //Código que me indica si es la primera
        val appModel = appRepository.fetch()
        if (appModel != null) {
            appRepository.save(AppLocalModel(appModel.isFirstTime, newValue))
        } else {
            appRepository.save(AppLocalModel(ratingValue = newValue))
        }
    }

    /**
     * Método que actualiza el rating.
     * Obtener el valor del repositorio y actualizar en el RatingBarr
     */
    private fun updateRatingValue() {
        var newValue = 0f
        val appModel = appRepository.fetch()
        if (appModel != null) {
            newValue = appModel.ratingValue
        }
        setRatingValue(newValue)
    }

    private fun setRatingValue(newValue: Float) {
        appRatingBar.rating = newValue
    }
}