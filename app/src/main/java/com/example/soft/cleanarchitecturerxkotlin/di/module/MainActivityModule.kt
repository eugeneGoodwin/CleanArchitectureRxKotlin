package com.example.soft.cleanarchitecturerxkotlin.di.module

import dagger.android.ContributesAndroidInjector
import com.example.soft.cleanarchitecturerxkotlin.di.scopes.PerFragment
import com.example.soft.cleanarchitecturerxkotlin.presentation.ui.PostsFragment
import com.example.soft.cleanarchitecturerxkotlin.presentation.ui.UsersFragment
import dagger.Module


@Module(includes = arrayOf(BaseActivityModule::class))
abstract class MainActivityModule {
    @PerFragment
    @ContributesAndroidInjector(modules = arrayOf(UsersFragmentModule::class))
    internal abstract fun usersFragmentInjector(): UsersFragment

    @PerFragment
    @ContributesAndroidInjector(modules = arrayOf(PostsFragmentModule::class))
    internal abstract fun postsFragmentInjector(): PostsFragment
}