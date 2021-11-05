package com.jmperezra.aad_playground.ut03.ex02.data

import androidx.room.*

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,

    @ColumnInfo(name = "name") val name: String,

    @ColumnInfo(name = "age") val age: Int
)

@Entity(tableName = "pet")
data class PetEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,

    @ColumnInfo(name = "name") val name: String,

    @ColumnInfo(name = "person_id") val personId: Int
)

/**
 * Una persona sólo puede tener una única mascota.
 *
 * Relación 1:1 donde Person cede su clave primaria a Pet.
 */
data class PersonAndPet(
    @Embedded val personEntity: PersonEntity, //Entidad Principal

    @Relation(
        parentColumn = "id", //clave primaria de la entidad Person.
        entityColumn = "person_id" //clave foránea de la entidad Pet.
    ) val petEntity: PetEntity, //Entidad que recibe la clave de otra entidad
)

/**
 * Una persona puede tener de 0 a N coches
 */
//@Entity(tableName = "car")
//data class CarEntity(
//    @PrimaryKey(autoGenerate = true) val carId: Int,
//    @ColumnInfo()
//)