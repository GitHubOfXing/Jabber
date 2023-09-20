package cn.xing.lib_kit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.xing.lib_kit.scope.PageScopeXKit
import cn.xing.lib_kit.scope.SceneScopeXKit

abstract class BasePage : AppCompatActivity() {

    private var pageScope: PageScopeXKit? = null


    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageScope = PageScopeXKit()

        if(application is BaseApp) {
            (application as BaseApp).getAppScope()?.setCurPageScope(pageScope!!)
        }
    }

    fun appendSceneScope(scene: SceneScopeXKit) {}

    abstract fun onPageCreate()
    abstract fun onPageResume()
    abstract fun onAttachAppScopeX()
    abstract fun onDetachAppScopeX()
    abstract fun onPageStop()
    abstract fun onPageDestroy()
}