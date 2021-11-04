package com.jmperezra.aad_playground.ut02.exercise03.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.jmperezra.aad_playground.R
import com.jmperezra.aad_playground.commons.Serializer


interface LocalStorage<T : LocalModel> {
    fun save(model: T)
    fun fetch(id: String): T?
}

class SharPrefLocalStorage<T : LocalModel>(
    private val activity: AppCompatActivity,
    private val serializer: Serializer<T>
) : LocalStorage<T> {

    private val sharedPref = activity.getSharedPreferences(
        activity.getString(R.string.preference_file_exercise02), Context.MODE_PRIVATE
    )

    override fun save(model: T) {
        val edit = sharedPref.edit()
        edit?.putString(model.getId(), serializer.toJson(model))
        edit?.apply()
    }

    override fun fetch(id: String): T? {
        val jsonModel = sharedPref.getString(id, "{}")
        return if (jsonModel != null) {
            serializer.fromJson(jsonModel)
        } else {
            null
        }
    }
}