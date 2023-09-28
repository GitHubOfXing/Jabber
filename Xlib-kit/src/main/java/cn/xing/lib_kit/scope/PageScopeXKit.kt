package cn.xing.lib_kit.scope

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

abstract class PageScopeXKit(val owner: LifecycleOwner?) {

    private var appScope: AppScopeXKit? = null

    private var pageContext: Context? = null

    private var curSceneScope: SceneScopeXKit? = null
    private var lastSceneScope: SceneScopeXKit? = null

    private  var pageScopeInfoPip: MutableLiveData<HashMap<PageInfoPipSignal, Bundle>> = MutableLiveData()

    private var appObserver = object: Observer<HashMap<AppScopeXKit.AppInfoPipSignal, Bundle>> {
        override fun onChanged(t: HashMap<AppScopeXKit.AppInfoPipSignal, Bundle>?) {

        }

    }

    fun setPageContext(pageContext: Context?) {
        this.pageContext = pageContext
    }

    fun getPageContext(): Context? {
        return pageContext
    }

    fun setCurSceneScope(sceneScope: SceneScopeXKit) {
        lastSceneScope = curSceneScope
        this.curSceneScope = sceneScope
        curSceneScope?.switchSceneStage(true)
        lastSceneScope?.switchSceneStage(false)
    }

    fun getCurSceneScope(): SceneScopeXKit? {
        return curSceneScope
    }

    fun getLastSceneScope(): SceneScopeXKit? {
        return lastSceneScope
    }

    fun gainPageScopePip(): MutableLiveData<HashMap<PageInfoPipSignal, Bundle>> {
        return pageScopeInfoPip
    }

    fun postPageScopePip(targetInfo: HashMap<PageInfoPipSignal, Bundle>) {
        pageScopeInfoPip.value = targetInfo
    }

    fun deactiveAppScope() {
        curSceneScope?.deactivePageScope()
        appScope?.gainAppScopePip()?.removeObserver(appObserver)
    }

    fun activeAppScope(appScopeXKit: AppScopeXKit) {
        this.appScope = appScopeXKit

        owner?.let {
            appScope?.gainAppScopePip()?.observe(it,appObserver)
        }

    }

    class PageInfoPipSignal {
        companion object {
//            val app_page_change = 1000001
        }
    }
}