package com.example.gestionalumnos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {

    private lateinit var db: AppDatabase
    private val viewModel: AlumnoViewModel by viewModels { AlumnoViewModel.Factory(db) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = AppDatabase.getDatabase(this)

        setContent {
            var nombre by remember { mutableStateOf("") }
            var asignatura by remember { mutableStateOf("") }
            var alumnos by remember { mutableStateOf(listOf<Alumno>()) }

            LaunchedEffect(viewModel) {
                viewModel.alumnos.collect { alumnos = it }
            }

            Column(modifier = Modifier.padding(16.dp)) {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = asignatura,
                    onValueChange = { asignatura = it },
                    label = { Text("Asignatura") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        if(nombre.isNotBlank() && asignatura.isNotBlank()) {
                            viewModel.agregarAlumno(nombre, asignatura)
                            nombre = ""
                            asignatura = ""
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Agregar Alumno")
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text("Lista de Alumnos:", style = MaterialTheme.typography.headlineLarge)
                LazyColumn {
                    items(alumnos) { alumno ->
                        Text("${alumno.nombre} - ${alumno.asignatura}")
                        Divider()
                    }
                }
            }
        }
    }
}