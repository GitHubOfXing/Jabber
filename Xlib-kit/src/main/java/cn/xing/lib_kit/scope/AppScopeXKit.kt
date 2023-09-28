package cn.xing.lib_kit.scope

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import cn.xing.xlib_account.AccountUser
import cn.xing.xlib_account.AccountXLib

abstract class AppScopeXKit {

    private var appContext: Context? = null

    private var accountXlib = AccountXLib()

    private var curPageScope: PageScopeXKit? = null
    private var lastPageScope: PageScopeXKit? = null

    private  var appScopeInfoPip:MutableLiveData<HashMap<AppInfoPipSignal,Bundle>> = MutableLiveData()

    fun setAppContext(applicationContext: Context?) {
        this.appContext = applicationContext
    }

    fun getAppContext(): Context? {
        return appContext
    }

    fun setCurPageScope(pageScope: PageScopeXKit) {
        lastPageScope = curPageScope
        curPageScope?.deactiveAppScope()
        this.curPageScope = pageScope
        curPageScope?.activeAppScope(this)
    }

    fun getCurPageScope(): PageScopeXKit? {
        return curPageScope
    }

    fun getLastPageScope(): PageScopeXKit? {
        return lastPageScope
    }

    fun gainAppScopePip(): MutableLiveData<HashMap<AppInfoPipSignal,Bundle>> {
        return appScopeInfoPip
    }

    fun postAppScopePip(targetInfo: HashMap<AppInfoPipSignal,Bundle>) {
        appScopeInfoPip.value = targetInfo
    }

    fun updateAccountInfo() {

    }

    abstract fun accountInfo()

    class AppInfoPipSignal {
        companion object {
            val app_account_login = 1000001
            val app_account_logout = 1000001
        }
    }
}