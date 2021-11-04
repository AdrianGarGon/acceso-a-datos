package com.jmperezra.aad_playground.ut02.exercise03.data

/**
 * Repositorio
 */
class AppRepository(private val localStorage: LocalStorage<AppLocalModel>) {

    fun fetch(): AppLocalModel? = localStorage.fetch(AppLocalModel.ID)

    fun save(appLocalModel: AppLocalModel) {
        localStorage.save(appLocalModel)
    }
}