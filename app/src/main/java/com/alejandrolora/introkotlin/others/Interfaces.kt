package com.alejandrolora.introkotlin.others

import android.util.Log

// DOC: #https://kotlinlang.org/docs/reference/interfaces.html

class Interfaces {

    private var anonymousObjectImplementingInterface: Any? = null

    private fun showCase1() {

        anonymousObjectImplementingInterface = object : Interface1 {
            override fun abstractMethod() {
                // Poner código es totalmente opcional
            }
        }
        // Necesitamos castear ya que en la declaración lo hacemos como Any y no puede inferir el tipo correctamente
        (anonymousObjectImplementingInterface as Interface1).methodWithImplementationByDefault()
        (anonymousObjectImplementingInterface as Interface1).abstractMethod()
    }

    private fun showCase2() {

        val aoii = object : Interface2 {
            override val propertyAbstract: Int
                get() = 10
        }

        aoii.propertyAbstract
        aoii.propertyWithImplementation
        aoii.hello()
    }

    fun showCases() {
        showCase1()
        showCase2()
    }
}

interface Interface1 {

    fun abstractMethod()

    fun methodWithImplementationByDefault() {

    }
}

interface Interface2 {

    val propertyAbstract: Int
    var propertyWithImplementation: String
        get() = "ByDefault"
        set(value) { this.propertyWithImplementation = value }

    fun hello() {
        Log.w("INTERFACE-2", "Is it working $propertyWithImplementation?, YaY! $propertyAbstract :)")
    }
}