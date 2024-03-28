package com.example.reactnativemoduleapp

import android.os.Bundle
import android.widget.Button
import com.reactnativemodule.ReactNativeModuleActivity

class MainActivity : ReactNativeModuleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            showReactNativeFragment(R.id.reactNativeFragment)
        }
    }
}