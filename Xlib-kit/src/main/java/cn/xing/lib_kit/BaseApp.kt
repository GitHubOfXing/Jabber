package cn.xing.lib_kit

import android.app.Application
import cn.xing.lib_kit.scope.AppScopeXKit

abstract class BaseApp : Application() {

    private val appScope: AppScopeXKit? = null

    override fun onCreate() {
        super.onCreate()
        appScope?.setAppContext(this.applicationContext)
    }

    abstract fun provideAppScopeXKit(): AppScopeXKit

    fun getAppScope(): AppScopeXKit? {
        return appScope
    }
}