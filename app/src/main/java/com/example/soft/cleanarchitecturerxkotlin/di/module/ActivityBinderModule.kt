package com.example.soft.cleanarchitecturerxkotlin.di.module

import com.example.soft.cleanarchitecturerxkotlin.di.scopes.PerActivity
import com.example.soft.cleanarchitecturerxkotlin.presentation.ui.MainActivity
import com.example.soft.cleanarchitecturerxkotlin.di.module.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinderModule {
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun mainActivity(): MainActivity
}