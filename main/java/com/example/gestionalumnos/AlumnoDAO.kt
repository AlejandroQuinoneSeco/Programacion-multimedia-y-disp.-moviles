package com.example.gestionalumnos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlumnoDao {
    @Query("SELECT * FROM Alumno")
    suspend fun getAlumnos(): List<Alumno>

    @Insert
    suspend fun insertar(alumno: Alumno)
}