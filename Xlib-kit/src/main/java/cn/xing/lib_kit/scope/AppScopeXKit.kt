package cn.xing.lib_kit.scope

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.MutableLiveData

class AppScopeXKit {

    private var appContext: Context? = null

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
        this.curPageScope = pageScope
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

    class AppInfoPipSignal {
        companion object {
//            val app_page_change = 1000001
        }
    }
}