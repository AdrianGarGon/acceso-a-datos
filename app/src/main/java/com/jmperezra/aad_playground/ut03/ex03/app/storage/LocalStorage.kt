package com.jmperezra.aad_playground.ut03.ex03.app.storage

interface LocalStorage<T : LocalModel> {
    fun fetch(modelId: String, typeClass: Class<T>): T?
    fun save(model: T, typeClass: Class<T>)
}