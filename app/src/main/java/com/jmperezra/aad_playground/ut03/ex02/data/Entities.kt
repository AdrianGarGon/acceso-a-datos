package com.jmperezra.aad_playground.ut03.ex02.data

import androidx.room.*
import com.jmperezra.aad_playground.ut03.ex02.domain.PersonModel
import com.jmperezra.aad_playground.ut03.ex02.domain.PetModel

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int? = 0,

    @ColumnInfo(name = "name") val name: String,

    @ColumnInfo(name = "age") val age: Int
)

{
    fun toModel(): PersonModel = PersonModel(id!!, name, age, null, PetModel(1, "pepe", 20))


}


@Entity(tableName = "pet")
data class PetEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int? = null,

    @ColumnInfo(name = "name") val name: String,

    @ColumnInfo(name = "person_id") val personId: Int,

    @ColumnInfo(name = "age") val age: Int


) {
    fun toModel() = PetModel(id!!, name, age)

}

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
) {
    fun toModel() = PersonModel(
        personEntity.id!!,
        personEntity.name,
        personEntity.age,
        "",
        PetModel(petEntity.id!!, petEntity.name,petEntity.age)



    )

}

/**
 * Una persona puede tener de 0 a N coches
 */
//@Entity(tableName = "car")
//data class CarEntity(
//    @PrimaryKey(autoGenerate = true) val carId: Int,
//    @ColumnInfo()
//)