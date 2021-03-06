package io.github.joaoevangelista.convertx

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.answers.Answers
import com.squareup.leakcanary.LeakCanary
import io.fabric.sdk.android.Fabric
import io.realm.Realm

/**
 * @author Joao Pedro Evangelista
 */
class ConvertxApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    if (LeakCanary.isInAnalyzerProcess(this)) return
    LeakCanary.install(this)
    enableReleaseOnly()
    Realm.init(this)
  }

  private fun enableReleaseOnly() {
    if (!BuildConfig.DEBUG) {
      Fabric.with(this, Crashlytics(), Answers())
    }
  }
}
