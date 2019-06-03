package com.example.soft.cleanarchitecturerxkotlin.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.soft.cleanarchitecturerxkotlin.presentation.viewmodel.PostsViewModel
import com.example.soft.cleanarchitecturerxkotlin.presentation.viewmodel.UsersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    internal abstract fun bindUsersViewModel(viewModel: UsersViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    internal abstract fun bindPostsViewModel(viewModel: PostsViewModel) : ViewModel
}