package com.quash.bugger_test

import android.app.Application


class BuggerApplication : Application() {

    companion object {
        lateinit var instance: BuggerApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}