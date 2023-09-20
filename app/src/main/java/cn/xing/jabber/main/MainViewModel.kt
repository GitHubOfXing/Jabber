package cn.xing.jabber.main

import cn.xing.lib_kit.BaseVM
import cn.xing.lib_kit.ViewModelType

class MainViewModel : BaseVM() {

    override fun viewModelType(): ViewModelType {
        return ViewModelType.PAGE
    }
}