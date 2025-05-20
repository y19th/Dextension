package com.y19th.dextension

import android.app.Application
import com.y19th.dextension.sample_default.end.di.endModule
import com.y19th.dextension.sample_default.navigator.navigatorModule
import com.y19th.dextension.sample_default.root.di.rootModule
import com.y19th.dextension.sample_default.start.di.startModule
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class MainApp : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                rootModule,
                startModule,
                endModule,
                navigatorModule
            )
        }

    }
}