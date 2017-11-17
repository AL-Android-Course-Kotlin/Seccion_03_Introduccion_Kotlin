package com.alejandrolora.introkotlin.others

// DOC: #https://kotlinlang.org/docs/reference/visibility-modifiers.html#classes-and-interfaces

// Para hacer una clase "extensible" o "heredable" tenemos que marcarlo como open.
// En Java es open por defecto y en Kotlin es final por defecto, así que no puede ser extendida sin el uso de 'open'

open class AccessModifiers {

    // private      -- sólo visible dentro de la clase
    // protected    -- sólo visible dentro de la clase y de sus subclases (herencia)
    // public       -- visible desde dentro de la clase, de sus subclases y desde fuera

    val prop1 = "Public by default"
    private val prop2 = "Marked as private"
    protected val prop3 = "Marked as protected"

    protected fun showCase() {
        val test = AccessModifiers()
        test.prop1
    }

}

class AccessModifiersChild : AccessModifiers() {

    private fun showCaseX() {
        super.showCase()
        prop1
        this.prop1
        // prop2 // Por ser private no puede ser accesible
        prop3
    }

}

class AnotherClass {

    private fun showCase() {
        val test = AccessModifiers()

        test.prop1

    }

}