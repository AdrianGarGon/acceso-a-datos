package com.jmperezra.aad_playground.ut02.exercise03.data

/**
 * Repositorio para el Rating de la App
 * Otra opción sería crear dos modelos con dos repositorios.
 */
class RatingRepository(private val localStorage: LocalStorage<RatingLocalModel>) {

    fun getRating(): RatingLocalModel? = localStorage.fetch(RatingLocalModel.ID)

    fun saveRating(localModel: RatingLocalModel) {
        localStorage.save(localModel)
    }
}