package cn.xing.lib_kit

import androidx.lifecycle.ViewModel
import cn.xing.lib_kit.scope.PageScopeXKit
import cn.xing.lib_kit.scope.SceneScopeXKit

abstract class BaseVM : ViewModel() {

    private var pageScope: PageScopeXKit? = null

    abstract fun viewModelType(): ViewModelType

    fun attachPageScope(pageScope: PageScopeXKit) {
        this.pageScope = pageScope
    }

    fun switchScene(sceneScope: SceneScopeXKit) {
        pageScope?.let {
            sceneScope.activePageScope(it)
            it.setCurSceneScope(sceneScope)
        }
    }

    fun release() {
        pageScope?.let {
            it.deactiveAppScope()
        }
    }

}

enum class ViewModelType {
    PAGE, CHIP, SCENE
}