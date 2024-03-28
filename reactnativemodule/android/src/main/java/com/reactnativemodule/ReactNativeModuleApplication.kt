package com.reactnativemodule

import android.app.Application
import com.facebook.react.PackageList
import com.facebook.react.ReactApplication
import com.facebook.react.ReactHost
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint
import com.facebook.react.defaults.DefaultReactHost
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.soloader.SoLoader

abstract class ReactNativeModuleApplication : Application(), ReactApplication {
    open var mIsNewArchEnabled: Boolean = false
    open var mIsHermesEnabled: Boolean = true

    abstract var mIsDebug: Boolean

    override val reactNativeHost: ReactNativeHost by lazy {
        object : DefaultReactNativeHost(this@ReactNativeModuleApplication) {
            override fun getPackages(): List<ReactPackage> =
                PackageList(this@ReactNativeModuleApplication).packages

            override fun getJSMainModuleName(): String = "index"

            override fun getUseDeveloperSupport(): Boolean = mIsDebug

            override val isNewArchEnabled: Boolean = mIsNewArchEnabled
            override val isHermesEnabled: Boolean = mIsHermesEnabled
        }
    }

    override val reactHost: ReactHost
        get() = DefaultReactHost.getDefaultReactHost(applicationContext, reactNativeHost)

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this@ReactNativeModuleApplication, false)
        if (mIsNewArchEnabled) {
            DefaultNewArchitectureEntryPoint.load()
        }
    }
}