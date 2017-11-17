package com.alejandrolora.introkotlin.others

// DOC: #https://kotlinlang.org/docs/reference/null-safety.html

class Nullable {
    /*
        Operadores relacionados con la nulabilidad:
            - only-safe (?)
            - non-null asserted (!!)

        Sistema de tipado de Kotlin está pensado para eliminar de nuestro código el NullPointerException.
        Los 4 únicos posibles casos para NPE son:

            1) Una llamada explícita al error NullPointerException()
            2) Uso del operador !!
            3) Código externo Java
            4) Alguna inconsistencia de datos en relación a la inicialización
    */
    private lateinit var variable1: String
    private var variable2: String? = null

    private fun showCase1() {
        throw NullPointerException()
    }

    private fun showCase2(var1: String?) {
        var1.toString() // Devuelve null en caso de que var1 sea null
        var1!!.toString() // Devuelve un NPE en caso de que var1 sea null
    }

    private fun showCase3() {
        Other.getNPE() // Devuelve un NPE
    }

    private fun showCase4() {
        variable1.length // Devuelve un NPE porque variable1 no ha sido latenit y se ha marcado como tal

        variable2?.length
        variable2!!.length
    }

    fun showCases() {
        showCase1()
        showCase2("")
        showCase3()
        showCase4()
    }

}