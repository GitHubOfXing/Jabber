package cn.xing.jabber.main.scene

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import cn.xing.jabber.databinding.SceneMainBinding
import cn.xing.lib_kit.BaseScene
import cn.xing.lib_kit.scope.SceneScopeXKit

class RecommendScene(private val owner: LifecycleOwner): BaseScene(owner) {

    private var sceneMainBinding: SceneMainBinding? = null

    override fun onSceneCreate(layoutInflater: LayoutInflater, container: ViewGroup) {
        sceneMainBinding = SceneMainBinding.inflate(layoutInflater,container,true)
    }

    override fun onSceneAttach() {

    }

    override fun onSceneDetach() {

    }

    override fun onSceneDestroy() {
        super.onSceneDestroy()

    }

    override fun sceneScope(): SceneScopeXKit {
        return RecommendSceneScopeXKit(owner)
    }

    override fun sceneName(): String {
        return RecommendScene::class.simpleName?:"MainScene"
    }
}