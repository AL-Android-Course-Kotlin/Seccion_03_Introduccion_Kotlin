package com.alejandrolora.introkotlin.others

import android.util.Log

// DOC: #https://kotlinlang.org/docs/reference/classes.html
// DOC: #https://kotlinlang.org/docs/reference/properties.html
// DOC: #https://kotlinlang.org/docs/reference/data-classes.html
// DOC: #https://kotlinlang.org/docs/reference/enum-classes.html
// DOC: #https://kotlinlang.org/docs/reference/object-declarations.html

// Clases son públicas y final por defecto
// Si queremos que una clase se pueda ser heredada, usaremos open (open class XXX)

class Classes {

    private fun showCase1() {
        // Clases en Kotlin pueden tener un constructor PRIMARIO y uno o más constructores SECUNDARIOS.
        // PRIMARIO se encuentra en la firma de la declaración de la clase.
        // SECUNDARIO se encuentra dentro de la declaración de la clase.

        // CONSTRUCTORES PRIMARIOS
        class Person1

        class Person2 constructor(var firstName: String) // constructor PRIMARIO
        class Person3(var firstName: String) // "constructor" puede ser omitido
        class Person4(val firstName: String, val lastName: String, var age: Int) {
            init {
                age = 10
            }
        }

        class Person5(val firstName: String = "Alejandro", val lastName: String = "Lora", var age: Int = 27)

        // Para crear instancias de objetos, no usamos la palabra "new"
        val p1 = Person1()
        val p2 = Person2("Alejandro")
        val p3 = Person3("Alejandro")
        val p4 = Person4("Alejandro", "Lora", 27)
        val p5_1 = Person5("Roberto", "Perez", 50)
        val p5_2 = Person5()
        val p5_3 = Person5("Roberto")
        val p5_4 = Person5(age = 50)
    }

    private fun showCase2() {
        // Clases en Kotlin pueden tener un constructor PRIMARIO y uno o más constructores SECUNDARIOS.
        // PRIMARIO se encuentra en la firma de la declaración de la clase.
        // SECUNDARIO se encuentra dentro de la declaración de la clase.

        // CONSTRUCTORES SECUNDARIOS (son menos usados en Kotlin)
        open class Person {
            constructor(firstName: String, lastName: String) {
                Log.w("CLASSES-2", "Welcome $firstName $lastName!")
            }
        }

        class Person1 : Person {
            constructor(firstName: String) : super(firstName, "Lora")
            constructor(firstName: String, lastName: String) : super(firstName, lastName)
        }

        val p = Person1("Alejandro", "Lora")
        // No tenemos acceso a person.firstName, ver showCase numero 5
    }

    private fun showCase3() {
        // Diferencia entre INIT Y CONSTRUCTOR secundario

        class Person1 {

            // Init se va a ejecutar antes que el constructor secundario y después que el constructor primario
            init {
                Log.w("CLASSES-3", "Welcome from INIT!") // No puedes acceder a firstName o lastName
            }

            constructor(firstName: String, lastName: String) {
                Log.w("CLASSES-3", "Welcome from SECONDARY CONSTRUCTOR!")
            }

        }

        class Person2(firstName: String, lastName: String) {
            init {
                // Aquí si podemos acceder a las propiedades, conservando init y constructor secundario
            }

            constructor() : this("Alejandro", "Lora")
        }

        val p1 = Person1("Alejandro", "Lora")
        val p2 = Person2("Roberto", "Perez")
        val p3 = Person2() // Alejandro Lora
    }

    private fun showCase4() {
        // ¿VAL, VAR O NADA EN EL CONSTRUCTOR?
        class Person1(firstName: String) // No puedes acceder a firstName cuando crees la instancia

        class Person2(var firstName: String) // Puedes acceder a firstName cuando crees la instancia. Puedes cambiar su valor
        class Person3(val firstName: String) // Puedes acceder a firstName cuando crees la instancia. No Puedes cambiar su valor

        val p1 = Person1("")
        val p2 = Person2("")
        val p3 = Person3("")

        // p1.firstName // Error
        p2.firstName
        p3.firstName
    }

    private fun showCase5() {
        // PROPIEDADES - GETTERS & SETTERS

        class Person1(var firstName: String)

        val p1 = Person1("Alejandro")
        p1.firstName // Sería el equivalente a getFirstName()
        p1.firstName = "Antonio" // Sería el equivalente a setFirstName("Antonio")

        class Person2 {
            // field - representa a la propiedad, nunca usar this.propiedad
            var firstName: String
                get() = field.capitalize()
                set(value) {
                    field = value.capitalize()
                }

            constructor(firstName: String, lastName: String) {
                this.firstName = firstName
            }
        }
    }

    private fun showCase6() {

        // HERENCIA E INTERFACES

        open class Person1(var name: String)
        open class Person2(open var name: String)
        open class Person3(open var name: String)

        // Si heredamos de Person1, las propiedades no se pueden llamar de igual forma entre padre e hijo
        // class Person11(var name: String) : Person1(name)

        // Podemos mantener ambas con el mismo nombre, peor tenemos que añadir open y override
        class Person22(override var name: String) : Person2(name)

        // Todo junto
        class Person33(override var name: String, override var age: Int) : Person3(name), IPerson {
            override fun hello() {}
        }
    }

    private fun showCase7() {
        // OVERRIDE y SUPER
        abstract class Person(open var firstName: String, open var lastName: String) {
            abstract fun hello()

            fun welcomeKotlin() {
                Log.w("CLASSES-7", "Welcome to Kotlin!")
            }

            open fun welcomeDevelopers() {
                Log.w("CLASSES-7", "Welcome Developers!")
            }
        }

        class Man(override var firstName: String, override var lastName: String) : Person(firstName, lastName) {
            override fun hello() {
                Log.w("CLASSES-7", "Hello, I am $firstName $lastName.")
            }
            override fun welcomeDevelopers() {
                super.welcomeDevelopers()
                super.welcomeKotlin()
                Log.w("CLASSES-7", "YaY!!")
            }

        }

        val man = Man("Alejandro", "Lora")
        man.hello()
        man.welcomeKotlin()
        man.welcomeDevelopers()
    }

    private fun showCase8() {
        // DATA CLASSES
        // Según la documentación oficial, para hacer uso correcto de Data Classes debe:
        // El constructor primario necesita tener al menos 1 parámetro
        // Todos los parámetros del constructor primario deben ser marcados como "val" o "var"
        // Data classes no pueden ser "abstract, open, sealed or inner"

        data class Person(var firstName: String, var lastName: String)

        val p = Person("Alejandro", "Lora")
        val p2 = p
        val personString = p.toString()
        val personCopy = p.copy()
        val clone = p.copy(firstName = "Antonio")
        val (firstName, lastName) = p // Destructuring

        Log.w("CLASSES-8", "Data class toString() => $personString")
        Log.w("CLASSES-8", "Data class copy() => $personCopy")
        Log.w("CLASSES-8", "p must be same reference than p2 => ${p === p2}") // True, Referential Equality
        Log.w("CLASSES-8", "p must be different reference than personCopy => ${p !== personCopy}") // True, Referential Equality
        Log.w("CLASSES-8", "p must have same property values than personCopy => ${p == personCopy}") // True, Structural Equality
        Log.w("CLASSES-8", "p must be different reference than clone => ${p !== clone}") // True, Referential Equality
        Log.w("CLASSES-8", "p must have different property values than clone => ${p != clone}") // True, Structural Equality
        Log.w("CLASSES-8", "firstName by destructuring must be 'Alejandro' => $firstName")
        Log.w("CLASSES-8", "lastName by destructuring must be 'Lora' => $lastName")
    }

    private fun showCase9() {
        // ENUM CLASSES

        Log.w("CLASSES-9", "ENUM DayOfWeek.MONDAY should be MONDAY => ${DayOfWeek.MONDAY.name}")
        Log.w("CLASSES-9", "ENUM DayOfWeek.MONDAY should be 0 => ${DayOfWeek.MONDAY.ordinal}")
        Log.w("CLASSES-9", "ENUM DayOfWeek.FRIDAY should be FRIDAY => ${DayOfWeek.FRIDAY.name}")
        Log.w("CLASSES-9", "ENUM DayOfWeek.FRIDAY should be 4 => ${DayOfWeek.FRIDAY.ordinal}")
    }


    fun showCases() {
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
        showCase7()
        showCase8()
        showCase9()
    }
}

interface IPerson {
    var age: Int
    fun hello()
}

enum class DayOfWeek { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }