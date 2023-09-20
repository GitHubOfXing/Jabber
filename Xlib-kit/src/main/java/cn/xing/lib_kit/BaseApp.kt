package cn.xing.lib_kit

import android.app.Application
import cn.xing.lib_kit.scope.AppScopeXKit

class BaseApp : Application() {

    private val appScope: AppScopeXKit?

    init {
        appScope = AppScopeXKit()
    }

    override fun onCreate() {
        super.onCreate()
        appScope?.setAppContext(this.applicationContext)
    }

    fun getAppScope(): AppScopeXKit? {
        return appScope
    }
}