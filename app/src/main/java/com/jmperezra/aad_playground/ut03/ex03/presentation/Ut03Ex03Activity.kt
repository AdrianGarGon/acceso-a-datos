package com.jmperezra.aad_playground.ut03.ex03.presentation

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.jmperezra.aad_playground.R

class Ut03Ex03Activity : AppCompatActivity() {

    private val viewModel: Ut03Ex03ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex03)
    }

    private fun getAllAlerts(){
        val alerts = viewModel.getAlerts()
        //..Visualizar la información en un LOG.
        Log.d(TAG, alerts.toString())
        // ¿Te atreves con un RecyclerView?
    }

    private fun getAlertById(){
        val alertId = ""
        val alerts = viewModel.findAlert(alertId)
        Log.d(TAG, alertId.toString())
        // ¿Te atreves con un RecyclerView?
    }
}