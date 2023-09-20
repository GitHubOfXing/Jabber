package cn.xing.lib_kit

import androidx.lifecycle.ViewModel
import cn.xing.lib_kit.scope.AppScopeXKit
import cn.xing.lib_kit.scope.PageScopeXKit
import cn.xing.lib_kit.scope.SceneScopeXKit
import java.lang.RuntimeException

abstract class BaseVM : ViewModel() {

    private var appScope: AppScopeXKit? = null
    private var pageScope: PageScopeXKit? = null
    private var sceneScope: SceneScopeXKit? = null

    fun gainAppScope(): AppScopeXKit? {
        return appScope
    }

    fun gainPageScope(): PageScopeXKit? {
        return pageScope
    }

    fun gainSceneScope(): SceneScopeXKit? {
        if(viewModelType() == ViewModelType.PAGE) throw RuntimeException("viewmodel type is page, gain sceneScope is illegal")
        return sceneScope
    }


    abstract fun viewModelType(): ViewModelType

}

enum class ViewModelType {
    PAGE, SCENE
}