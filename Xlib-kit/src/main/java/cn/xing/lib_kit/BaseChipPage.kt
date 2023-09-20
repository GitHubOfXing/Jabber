package cn.xing.lib_kit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseChipPage  : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun onSceneCreate()
    abstract fun onSceneResume()
    abstract fun onAttachPageScopeX()
    abstract fun onDetachPageScopeX()
    abstract fun onSceneStop()
    abstract fun onSceneDestroy()

}