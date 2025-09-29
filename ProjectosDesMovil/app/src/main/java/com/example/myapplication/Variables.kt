package com.example.myapplication

fun main() {

    /**
     *  Valores alfanuméricos
     */

    // Constantes char
    val variableChar:Char = 'c'

    // Constantes string
    val texto:String = "texto"

    // Constantes booleanas
    val variableBooleana:Boolean = true

    /**
     * Variables
     */

    var age:Int = 30

    fun imprimir(){
        println("Función Imprimir")
    }

    fun imprimirEdad(edad:Int){
        println("Función imprimir edad $edad")
    }

    fun imprimirEdadPorDefecto(edad:Int = 40){
        println("Función imprimir edad por defecto $edad")
    }

}