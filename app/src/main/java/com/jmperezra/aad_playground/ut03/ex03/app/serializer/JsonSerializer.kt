package com.jmperezra.aad_playground.ut03.ex03.app.serializer

interface JsonSerializer {
    fun <T> toJson(obj: T, typeClass: Class<T>): String
    fun <T> fromJson(json: String, typeClass: Class<T>): T
}