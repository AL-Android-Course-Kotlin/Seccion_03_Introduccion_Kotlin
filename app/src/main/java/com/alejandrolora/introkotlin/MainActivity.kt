package com.alejandrolora.introkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alejandrolora.introkotlin.others.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Variables().showCases()
        Nullable() // Si llamamos al showCases tendremos NPE
        Operators().showCases()
        ControlFlow().showCases()
        AccessModifiers()
        Interfaces().showCases()
        Classes().showCases()
        Functions().showCases()
        CompanionObject().showCases()
    }
}
