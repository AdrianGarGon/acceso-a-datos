package com.jmperezra.aad_playground.ut02.exercise02

/**
 * Clase que me permite guardar y recuperar modelos de datos de tipo Tapa
 *
 * Pista: La clase debe ser inicializada con una fuente de datos y un modelo en concreto.
 * Pista II: Como estamos hablando de TapaRepository, es el momento de concretar el modelo de datos
 *           con el que queremos trabajar: TapaLocalModel.
 */
class TapaRepository(private val dataSource: DataSource<TapaLocalModel>) {

    /**
     * Guardo un modelo de datos de tipo Tapa
     */
    fun save(tapa: TapaLocalModel) {
        dataSource.save(tapa)
    }

    /**
     * Recupero un modelo de datos de tipo Tapa
     */
    fun fetch(id: Int): TapaLocalModel? = dataSource.fetch(id.toString())
}