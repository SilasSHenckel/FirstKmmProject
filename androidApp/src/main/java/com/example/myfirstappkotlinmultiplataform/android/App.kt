package com.example.myfirstappkotlinmultiplataform.android

import android.app.Application
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(){



    override fun onCreate() {
        super.onCreate()

        Firebase.initialize( this )
        startKoin {
            androidContext(this@App)

//            modules(DataModule().get())
//            modules(DomainModule().get())
//            modules(PresentationModule().get())
        }

    }
}