package com.example.soft.cleanarchitecturerxkotlin

import android.app.Activity
import android.app.Application
import com.example.soft.cleanarchitecturerxkotlin.di.component.DaggerAppComponent
import com.example.soft.cleanarchitecturerxkotlin.di.module.IOModule
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {
    override fun activityInjector(): DispatchingAndroidInjector<Activity> = androidInjector
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Activity>

    val SERVER_ENDPOINT = "https://jsonplaceholder.typicode.com/"

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().app(this).ioModule(IOModule(SERVER_ENDPOINT)).build().inject(this)
    }
}