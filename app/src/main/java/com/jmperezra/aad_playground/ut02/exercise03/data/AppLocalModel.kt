package com.jmperezra.aad_playground.ut02.exercise03.data

interface LocalModel {
    fun getId(): String
}

data class AppLocalModel(val isFirstTime: Boolean = true, val ratingValue: Float = 0f) :
    LocalModel {
    override fun getId(): String = ID

    companion object {
        val ID: String = AppLocalModel::class.java.simpleName
    }
}

/**
 * Opción 2: Si se opta por crear modelos independientes junto con RatingRepository
 */
data class RatingLocalModel(val rate: Float = 0f) : LocalModel {
    override fun getId(): String = ID

    companion object {
        val ID: String = RatingLocalModel::class.java.simpleName
    }
}