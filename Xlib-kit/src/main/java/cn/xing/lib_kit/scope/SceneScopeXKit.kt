package cn.xing.lib_kit.scope

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

abstract class SceneScopeXKit(val owner: LifecycleOwner?) {

    private var pageScopeXKit: PageScopeXKit? = null

    private var event = HashMap<Int, Bundle>()

    private var pageObserver = object: Observer<HashMap<PageScopeXKit.PageInfoPipSignal, Bundle>> {
        override fun onChanged(t: HashMap<PageScopeXKit.PageInfoPipSignal, Bundle>?) {

        }
    }

    private var sceneScopeInfoPip: MutableLiveData<HashMap<Int, Bundle>> = MutableLiveData()

    fun gainSceneScopePip(): MutableLiveData<HashMap<Int, Bundle>> {
        return sceneScopeInfoPip
    }

    fun postSceneScopePip(targetInfo: HashMap<Int, Bundle>) {
        sceneScopeInfoPip.value = targetInfo
    }

    fun deactivePageScope() {
        pageScopeXKit?.gainPageScopePip()?.removeObserver(pageObserver)
    }

    fun activePageScope(pageScopeXKit: PageScopeXKit) {
        this.pageScopeXKit = pageScopeXKit

        owner?.let {
            pageScopeXKit.gainPageScopePip().observe(it, pageObserver)
        }
    }

    fun switchSceneStage(isSceneStage: Boolean) {
        event.clear()
        if(isSceneStage) {
            event[SceneInfoPipSignal.scene_attach] = Bundle()
        } else {
            event[SceneInfoPipSignal.scene_detach] = Bundle()
        }
        postSceneScopePip(event)
    }

    class SceneInfoPipSignal {
        companion object {
            val scene_attach = 1000001
            val scene_detach = 1000002
        }
    }
}