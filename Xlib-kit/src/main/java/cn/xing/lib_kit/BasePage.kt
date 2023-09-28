package cn.xing.lib_kit

import android.os.Build
import android.os.Bundle
import android.util.ArrayMap
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import cn.xing.lib_kit.databinding.BasePageContainerBinding
import cn.xing.lib_kit.scope.PageScopeXKit


abstract class BasePage : AppCompatActivity() {

    protected var pageVM: BaseVM? = null

    private var sceneMap = ArrayMap<String, BaseScene>()

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar()
        val binding = BasePageContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pageScope = providerPageScopeXKit()
        if (application is BaseApp) {
            (application as BaseApp).getAppScope()?.setCurPageScope(pageScope)
        }
        pageVM = providerPageVM()
        pageVM?.attachPageScope(pageScope)
        declarePageScenes(sceneMap)
        onPageCreate(binding.kitMainContainer)
        onInitScene()
    }

    private fun setStatusBar() {
        WindowInsetsControllerCompat(window, window.decorView).let {
            it.hide(WindowInsetsCompat.Type.statusBars())
            it.hide(WindowInsetsCompat.Type.navigationBars())
            it.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val lp = window.attributes
            lp.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            window.attributes = lp

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.setDecorFitsSystemWindows(false)
            } else {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }
        }
    }

    final override fun onResume() {
        super.onResume()
        onPageResume()
    }

    final override fun onDestroy() {
        super.onDestroy()
        onPageDestroy()
    }

    abstract fun onPageCreate(kitMainContainer: ViewGroup)
    abstract fun onPageResume()
    abstract fun onPageDestroy()

    /**
     * init scene使用
     */
    abstract fun onInitScene()

    abstract fun declarePageScenes(sceneMap: ArrayMap<String, BaseScene>)

    fun gainTargetScene(sceneName: String): BaseScene? {
        if(sceneMap.contains(sceneName)) {
            return sceneMap[sceneName]
        }
        return null
    }

    fun sceneAttach(targetScene: BaseScene) {
        targetScene.gainSceneScope()?.let {
            pageVM?.switchScene(it)
        }
    }

    abstract fun providerPageVM(): BaseVM
    abstract fun providerPageScopeXKit(): PageScopeXKit
}