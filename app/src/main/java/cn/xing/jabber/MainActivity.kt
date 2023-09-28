package cn.xing.jabber

import android.util.ArrayMap
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import cn.xing.jabber.databinding.ActivityMainBinding
import cn.xing.jabber.main.MainPageScopeXKit
import cn.xing.jabber.main.scene.MainScene
import cn.xing.jabber.main.MainViewModel
import cn.xing.jabber.main.scene.RecommendScene
import cn.xing.lib_kit.BasePage
import cn.xing.lib_kit.BaseScene
import cn.xing.lib_kit.BaseVM
import cn.xing.lib_kit.scope.PageScopeXKit

class MainActivity : BasePage() {

    private var binding: ActivityMainBinding? = null

    override fun onPageCreate(kitMainContainer: ViewGroup) {
        binding = ActivityMainBinding.inflate(layoutInflater,kitMainContainer,true)
    }

    override fun onPageResume() {

    }

    override fun onPageDestroy() {
        pageVM?.release()
    }

    override fun onInitScene() {
        binding?.let { viewRoot ->
            val target = gainTargetScene(MainScene::class.simpleName.toString())
            target?.let {
                it.onSceneCreate(layoutInflater,viewRoot.sceneContainer)
                sceneAttach(it)
            }
        }
    }

    override fun declarePageScenes(sceneMap: ArrayMap<String, BaseScene>) {
        val mainScene = MainScene(this)
        sceneMap[mainScene.sceneName()] = mainScene
        val recommendScene = RecommendScene(this)
        sceneMap[recommendScene.sceneName()] = recommendScene
    }

    override fun providerPageVM(): BaseVM {
        return ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
            MainViewModel::class.java
        )
    }

    override fun providerPageScopeXKit(): PageScopeXKit {
        return MainPageScopeXKit(this)
    }

}