package com.example.soft.cleanarchitecturerxkotlin.di.module

import com.example.soft.cleanarchitecturerxkotlin.di.scopes.PerFragment
import com.example.soft.cleanarchitecturerxkotlin.presentation.adapters.UsersAdapter
import dagger.Module
import dagger.Provides

@Module
abstract class UsersFragmentModule {
    @Module
    companion object {
        @Provides
        @PerFragment
        fun provideUsersAdapter() = UsersAdapter()
    }
}