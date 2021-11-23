package com.jmperezra.aad_playground.ut03.ex03.data.local.db


import android.content.Context
import com.jmperezra.aad_playground.ut03.ex03.app.db.AppDataBase
import com.jmperezra.aad_playground.ut03.ex03.data.local.AlertLocalSource
import com.jmperezra.aad_playground.ut03.ex03.domain.AlertModel

class AlertDbLocalSource2  (private val appContext : Context) : AlertLocalSource {

    private val db = AppDataBase.getInstance(appContext)

    override fun findAll(): List<AlertModel> {
        val AlertAndFiles = db.alertDao().findAll()
        return AlertAndFiles.map {element -> element.toModel()}

    }

    override fun save(alerts: List<AlertModel>) {
        db.alertDao().insertAlertAndFiles(
            AlertEntity.toEntity(alertModel)
        )
    }

    override fun save(alert: AlertModel) {
        TODO("Not yet implemented")
    }

    override fun findById(alertId: String): AlertModel? {
        TODO("Not yet implemented")
    }
}