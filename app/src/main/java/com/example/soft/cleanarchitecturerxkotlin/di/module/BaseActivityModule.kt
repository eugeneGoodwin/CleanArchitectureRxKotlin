package com.example.soft.cleanarchitecturerxkotlin.di.module

import android.app.Activity
import android.content.Context
import com.example.soft.cleanarchitecturerxkotlin.di.scopes.PerActivity
import dagger.Binds
import dagger.Module

@Module
abstract class BaseActivityModule {
    @Binds
    @PerActivity
    abstract fun activityContext(activity: Activity): Context
}