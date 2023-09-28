package cn.xing.jabber

import cn.xing.lib_kit.BaseApp
import cn.xing.lib_kit.scope.AppScopeXKit

class JabberApp: BaseApp() {

    override fun provideAppScopeXKit(): AppScopeXKit {
        return JabberAppScope()
    }

    class JabberAppScope: AppScopeXKit() {
        override fun accountInfo() {

        }

    }
}