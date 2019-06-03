package com.example.soft.cleanarchitecturerxkotlin.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.soft.cleanarchitecturerxkotlin.data.repository.PostRepository
import com.example.soft.cleanarchitecturerxkotlin.data.repository.PostRepositoryInterface
import com.example.soft.cleanarchitecturerxkotlin.data.repository.UserRepository
import com.example.soft.cleanarchitecturerxkotlin.data.repository.UserRepositoryInterface
import com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.PostDataStoreFactory
import com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.UserDataStoreFactory
import com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.db.PostDBDataStoreImpl
import com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.db.UserDBDataStoreImpl
import com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.remote.PostRemoteDataStoreImpl
import com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.remote.UserRemoteDataStoreImpl
import com.example.soft.cleanarchitecturerxkotlin.domain.executor.JobExecutor
import com.example.soft.cleanarchitecturerxkotlin.domain.executor.PostExecutionThread
import com.example.soft.cleanarchitecturerxkotlin.domain.executor.ThreadExecutor
import com.example.soft.cleanarchitecturerxkotlin.domain.executor.UIThread
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class AppModule() {

    @Provides @Singleton fun provideApplicationContext(app: Application): Context = app
    @Provides @Singleton fun provideSharedPreference(app: Application): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)
    @Provides @Singleton fun provideThreadExecutor(): ThreadExecutor = JobExecutor()
    @Provides @Singleton fun providePostExecutionThread(): PostExecutionThread = UIThread()
    @Provides @Singleton fun provideUserRepository(dataSource: UserRepository): UserRepositoryInterface = dataSource
    @Provides @Singleton fun providePostRepository(dataSource: PostRepository): PostRepositoryInterface = dataSource

    @Provides @Singleton fun provideUserDataStoreFactory(userRemoteDataStoreImpl: UserRemoteDataStoreImpl,
                                                         userDBDataStoreImpl: UserDBDataStoreImpl): UserDataStoreFactory  = UserDataStoreFactory(userRemoteDataStoreImpl, userDBDataStoreImpl)
    @Provides @Singleton fun providePostDataStoreFactory(postRemoteDataStoreImpl: PostRemoteDataStoreImpl,
                                                         postDBDataStoreImpl: PostDBDataStoreImpl): PostDataStoreFactory  = PostDataStoreFactory(postRemoteDataStoreImpl, postDBDataStoreImpl)
}