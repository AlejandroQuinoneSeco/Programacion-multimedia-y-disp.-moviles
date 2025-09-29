package com.example.myapplication

fun main() {

    val nombre = "Aris"
    if (nombre == "Aris"){
        println("Se llama Aris") // Se ejecutará esta linea
    } else {
        println("No se llama Aris")
    }

    val animal = "Perro"
    if (animal == "Perro"){
        println("Es un perro") // Se ejecutará esta linea
    } else {
        println("No es un perro")
    }

    val vidaEnemigo = 100
    val ataqueCarta = 50


    val diaSemana = 6
    val nombreDia = when (diaSemana){
        1 -> "lunes"
        2 -> "Martes"
        3 -> "Miércoles"
        4 -> "Jueves"
        5 -> "Viernes"
        6,7 -> "Finde"
        else -> "Finde again"
    }
    println("Hoy es $nombreDia")

    val diaSemana2 = arrayOf("Lunes, Martes, Miércoles")

    /**
    fun getPuntuacion(puntuacion2: Int):String{

        val puntuacion = 75

        return when: (puntuacion: Int): String {
            in 90 <= .. <= 100 -> println("Sobresaliente")
            in 70 <= .. <= 89 -> println ("Notable")
            in 50 <= .. <= 69 -> println ("Suficiente")
            else -> println("no aprobado")
        }

    }
    **/
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val mul = {x: Int, y: Int -> x * y}
    val res = doOp(2, 3) {x, y -> x - y}
    println(res)

    fun doOp(x:Int, y:Int, op: (Int, Int) -> Int) = op(x, y)
}
