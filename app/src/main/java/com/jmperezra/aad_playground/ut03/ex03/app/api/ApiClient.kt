package com.jmperezra.aad_playground.ut03.ex03.app.api

import com.jmperezra.aad_playground.ut03.ex03.data.remote.AlertApiModel

interface ApiClient {
    fun getAlerts(): List<AlertApiModel>
    fun getAlert(alertId: String): AlertApiModel?
}