package cn.xing.lib_kit

import android.content.Context
import android.view.ViewGroup

abstract class BaseScene(context: Context) : ViewGroup(context) {

    abstract fun onSceneCreate()
    abstract fun onSceneResume()
    abstract fun onAttachPageScopeX()
    abstract fun onDetachAppScopeX()
    abstract fun onPageStop()
    abstract fun onPageDestroy()

}