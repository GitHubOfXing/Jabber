package cn.xing.lib_kit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import cn.xing.lib_kit.scope.SceneScopeXKit

abstract class BaseScene(owner: LifecycleOwner) {

    private var sceneScope: SceneScopeXKit? = null

    private var sceneObserver = object: Observer<HashMap<Int, Bundle>> {
        override fun onChanged(t: HashMap<Int, Bundle>?) {
            t?.keys?.forEach {
                when(it) {
                    SceneScopeXKit.SceneInfoPipSignal.scene_attach -> {
                        onSceneAttach()
                    }
                    SceneScopeXKit.SceneInfoPipSignal.scene_detach -> {
                        onSceneDetach()
                    }
                }
            }
        }
    }

    init {
        sceneScope = sceneScope()
        sceneScope?.gainSceneScopePip()?.observe(owner,sceneObserver)
    }

    fun gainSceneScope(): SceneScopeXKit? {
        return sceneScope
    }

    abstract fun onSceneCreate(layoutInflater: LayoutInflater, container: ViewGroup)

    abstract fun onSceneAttach()

    abstract fun onSceneDetach()

    open fun onSceneDestroy() {
        sceneScope?.gainSceneScopePip()?.removeObserver(sceneObserver)
    }

    abstract fun sceneScope(): SceneScopeXKit

    abstract fun sceneName(): String

}