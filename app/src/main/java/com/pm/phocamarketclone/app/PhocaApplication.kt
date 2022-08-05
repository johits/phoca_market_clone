package com.pm.phocamarketclone.app

import android.app.Application
import timber.log.Timber

class PhocaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}