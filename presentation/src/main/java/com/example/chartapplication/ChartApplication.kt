package com.example.chartapplication

import android.annotation.SuppressLint
import com.example.chartapplication.di.component.ApplicationComponent
import com.example.chartapplication.di.component.DaggerApplicationComponent
import com.example.chartapplication.di.modules.ApplicationModule
import dagger.android.DaggerApplication

class ChartApplication: DaggerApplication() {

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    private fun injectMembers() = appComponent.inject(this)

    @SuppressLint("CheckResult")
    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    override fun applicationInjector() = appComponent
}