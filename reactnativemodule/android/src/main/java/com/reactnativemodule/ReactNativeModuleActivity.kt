package com.reactnativemodule

import androidx.appcompat.app.AppCompatActivity
import com.facebook.react.ReactFragment
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler

open class ReactNativeModuleActivity : AppCompatActivity(), DefaultHardwareBackBtnHandler {

    protected fun showReactNativeFragment(
        fragmentHostLayoutId: Int,
    ) {
        val reactNativeFragment = ReactFragment.Builder()
            .setComponentName("ReactNativeModule")
            .setFabricEnabled(false)
            .build()
        supportFragmentManager
            .beginTransaction()
            .add(fragmentHostLayoutId, reactNativeFragment)
            .commit()
    }

    override fun invokeDefaultOnBackPressed() {
        onBackPressedDispatcher.onBackPressed()
    }
}