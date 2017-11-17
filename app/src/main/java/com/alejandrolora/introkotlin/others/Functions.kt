package com.alejandrolora.introkotlin.others

import android.util.Log
import java.util.*

// DOC: #https://kotlinlang.org/docs/reference/functions.html
// DOC: #https://kotlinlang.org/docs/reference/inline-functions.html

class Functions {

    private fun showCase1() {
        // Funciones, parámetros y Unit

        fun function1() {}
        val result1 = function1()

        fun function2(): Unit {}
        val result2: Unit = function2()

        // Los parametros de las funciones necesitan especificar su tipo, siempre
        fun function3(param1: String, param2: String): String {
            return "$param1, $param2"
        }

        val result3 = function3("String 1", "String 2")

        fun function4(param: Int = 5) {}
        fun function5(param: Int?) {}
    }

    private fun showCase2() {
        // Funciones con funciones como parámetros(callback) y llamadas por lambda

        fun printSum(num1: Int, num2: Int, printer: (result: Int) -> Unit) {
            printer(num1 + num2)
        }

        printSum(5, 5) { result ->
            Log.w("FUNCTIONS-2", "Lambda expression printing the sum result (10) => $result")
        }

        // Si el callback recibe sólo un parametro, podemos omitir ese "result" -> it
        printSum(12, 12) {
            Log.w("FUNCTIONS-2", "Lambda expression printing the sum result (24) => $it")
        }

        fun printSum2(num1: Int, num2: Int, printer: (result: Int, param1: Int, param2: Int) -> Unit) {
            printer(num1 + num2, num1, num2)
        }

        printSum2(7, 7) { result, param1, param2 ->
            Log.w("FUNCTIONS-2", "Lambda expression printing the sum result (14) => $result")
        }

        printSum2(7, 7) { result, _, _ ->
            Log.w("FUNCTIONS-2", "Lambda expression printing the sum result (14) => $result")
        }
    }

    private fun showCase3() {
        // Named arguments

        fun function1(firstName: String, lastName: String, age: Int, city: String, dateOfBirth: Date) {
            //
        }

        function1("", "", 27, "", Date())
        function1(age = 27, dateOfBirth = Date(), firstName = "Alejandro", city = "Sevilla", lastName = "Lora")
    }

    private fun showCase4() {
        // Single-Expression functions
        fun sum1(param1: Int, param2: Int): Int {
            return param1 + param2
        }

        fun sum2(param1: Int, param2: Int) = param1 + param2
    }

    private fun showCase5() {
        // Variable number of arguments (Varargs)
        fun sumAll(vararg numbers: Int) = numbers.sum()

        val result = sumAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        Log.w("FUNCTIONS-5", "vararg result is 55 => $result")
    }

    private fun showCase6() {
        // Extension Functions

        // Si es declarada dentro de este método, sólo tenemos acceso a él en este mismo contexto de función
        fun String.welcome() {
            Log.w("FUNCTIONS-6", "Welcome to Kotlin and to Extension Functions!")
        }
        "".welcome()
    }

    fun showCases() {
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
//        "".welcome()
        "".welcomeKotlin()
    }
}

// Si es declarada aquí, se tendrá acceso en toda la app
fun String.welcomeKotlin() {
    Log.w("FUNCTIONS-6", "Welcome to Kotlin and to Extension Functions Globally!")
}
