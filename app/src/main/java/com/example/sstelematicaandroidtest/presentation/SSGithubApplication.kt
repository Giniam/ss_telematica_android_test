package com.example.sstelematicaandroidtest.presentation

import android.app.Application
import com.example.sstelematicaandroidtest.core.di.AppModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class SSGithubApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() = org.koin.core.context.startKoin {
        androidContext(this@SSGithubApplication)
        modules(AppModules.modules)
        androidLogger()
    }
}