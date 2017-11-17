package com.alejandrolora.introkotlin.others

import android.util.Log

// DOC: #https://kotlinlang.org/docs/reference/basic-types.html

/*
En Kotlin todo es un objeto.
No hay tipos básicos, y no existe void. Si algo no devuelve nada, está devolviendo Unit object.
Las variables pueden ser mutables o inmutables, usaremos inmutables siempre que sea posible. ( var vs val)
Los tipos son definidos despues del nombre de la variable, con dos puntos y espacio ( var nombre: tipo)
*/

class Variables {

    private var variable0 = 1                           // Int
    private var variable1 = 1.toByte()                  // Byte == var variable1: Byte = 1
    private var variable2 = -123                        // Int
    private var variable3 = 2147483648                  // Long -- Infiere como long si es mayor que Int
    private var variable4 = 1.1.toFloat()               // Float
    private var variable5 = 1.9                         // Double
    private var variable6 = 'a'                         // Char
    private var variable7 = "a"                         // String
    private var variable8 = true                        // Boolean
    private var variable9 = arrayOf(1, 2, 3, 4, 5)      // Int Array
    private var variable10 = arrayOfNulls<Int>(10) // [null, null] solo acepta Int
    private val variable11 = "Esta variable es read-only/inmutable/constante"

    // Show Case para Byte
    private fun showCase1() {
        Log.w("VARIABLE-0", "¿Es variable0 un Integer? --> " + (variable0 is Int) + " ¿Por qué no un Byte?")
        Log.w("VARIABLE-1", "¿Es variable1 un Byte? --> " + (variable1 is Byte))
    }

    // Show Case para Int
    private fun showCase2() {
        Log.w("VARIABLE-2", "Es un valor Integer")
        variable2 = Int.MAX_VALUE
    }

    // Show Case para Long
    private fun showCase3() {
        Log.w("VARIABLE-3", "¿Es un valor Long? --> " + (variable3 is Long))
    }

    // Show Case para Float
    private fun showCase4() {
        Log.w("VARIABLE-4", "¿Es un valor Float? --> " + (variable4 is Float))
    }

    // Show Case para Double
    private fun showCase5() {
        Log.w("VARIABLE-5", "¿Es un valor Double? --> " + (variable5 is Double))
    }

    // Show Case para Char
    private fun showCase6() {
        Log.w("VARIABLE-6", "¿Es un valor Char? --> " + (variable6 is Char))
    }

    // Show Case para String
    private fun showCase7() {
        Log.w("VARIABLE-7", "¿Es un valor String? --> " + (variable7 is String))

        // String Literals
        variable7 = "¡Hola Mundo!\n¡Adiós Mundo!" // Java's style
        variable7 = """
                        ¡Hola Mundo!
                        ¡Adiós Mundo!
                    """ // Kotlin's style

        // String Templates
        var points = 9
        var maxPoints = 10
        variable7 = "Hola, tengo " + points + " puntos sobre " + maxPoints // Java's style
        variable7 = "Hola, tengo $points puntos sobre $maxPoints"// Kotlin's style
        variable7 = "Hola, tengo ${points * 10} puntos sobre ${maxPoints * 10}"// Kotlin's style
    }

    // Show Case para Boolean
    private fun showCase8() {
        Log.w("VARIABLE-8", "¿Es un valor Boolean? --> " + (variable8 is Boolean))
    }

    // Show Case para Array<Int>
    private fun showCase9() {
        Log.w("VARIABLE-9", "¿Es un valor Array<Int>? --> " + (variable9 is Array<Int>))
    }

    // Show Case para Array<Int?>
    private fun showCase10() {
        Log.w("VARIABLE-10", "¿Es un valor Array<Int>? --> " + (variable10 is Array<Int?>))

        variable10 = arrayOfNulls(3)
        variable10 = arrayOf(1, 2, 3, 4, 5)

        variable10[0]?.toFloat() // Safe Calls -- En caso de ser null, devuelve null
        variable10[0]?.toFloat() ?: "Error" // Elvis Operator -- En caso de ser null, devuelve "Error"
        variable10[0]!!.toFloat() // The !! Operator -- Cuando estamos seguro que no es nulo al 100%, si lo fuera, lanza un NPE

    }

    fun showCases() {
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
        showCase7()
        showCase9()
        showCase10()
    }

}