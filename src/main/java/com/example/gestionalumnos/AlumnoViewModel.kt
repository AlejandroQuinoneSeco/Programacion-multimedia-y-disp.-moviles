package com.example.gestionalumnos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AlumnoViewModel(private val db: AppDatabase) : ViewModel() {

    private val _alumnos = MutableStateFlow<List<Alumno>>(emptyList())
    val alumnos: StateFlow<List<Alumno>> get() = _alumnos

    init {
        cargarAlumnos()
    }

    private fun cargarAlumnos() {
        viewModelScope.launch {
            _alumnos.value = db.alumnoDao().getAlumnos()
        }
    }

    fun agregarAlumno(nombre: String, asignatura: String) {
        viewModelScope.launch {
            db.alumnoDao().insertar(Alumno(nombre = nombre, asignatura = asignatura))
            cargarAlumnos()
        }
    }

    class Factory(private val db: AppDatabase) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlumnoViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AlumnoViewModel(db) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}