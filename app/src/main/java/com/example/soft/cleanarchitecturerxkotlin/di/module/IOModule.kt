package com.example.soft.cleanarchitecturerxkotlin.di.module

import dagger.Module
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import com.google.gson.Gson
import javax.inject.Singleton
import dagger.Provides
import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.Cache
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.File


@Module
class IOModule(private val baseUrl: String) {

    private fun getGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    /*private fun getHttpCashe(application: Application): Cache {
        val cacheSize:Long = 10 * 1024 * 1024
        val httpCacheDirectory = File(application.cacheDir, "responses")
        return Cache(httpCacheDirectory, cacheSize)
    }*/

    private fun createClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        //client.cache(getHttpCashe())
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .client(createClient())
                .build()
    }
}