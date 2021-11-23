package com.jmperezra.aad_playground.ut03.ex03.data.local.db

import android.content.Context
import com.jmperezra.aad_playground.ut03.ex03.app.db.AppDataBase
import com.jmperezra.aad_playground.ut03.ex03.data.local.AlertLocalSource
import com.jmperezra.aad_playground.ut03.ex03.domain.AlertModel

class AlertDbLocalSource(private val appContext: Context) : AlertLocalSource {

    private val db = AppDataBase.getInstance(appContext)

    override fun findAll(): List<AlertModel> {
        val dbAlerts = db.alertDao().findAll()
        return dbAlerts.map { alertEntity -> alertEntity.toModel() }
    }

    override fun save(alerts: List<AlertModel>) {
        alerts.forEach { alertModel -> db.runInTransaction { save(alertModel) } }
    }

    override fun save(alert: AlertModel) {
        db.alertDao().insert(
            AlertEntity.toEntity(alert),
            alert.files.map { fileModel -> FileEntity.toEntity(alert.id, fileModel) })
    }

    override fun findById(alertId: String): AlertModel? {
        val alertEntity = db.alertDao().findById(alertId)
        return alertEntity?.toModel()
    }
}