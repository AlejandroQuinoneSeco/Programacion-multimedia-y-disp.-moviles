package com.example.gestionalumnos

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Alumno(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val asignatura: String
)