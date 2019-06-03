package com.example.soft.cleanarchitecturerxkotlin.data.repository

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetService @Inject constructor(val retrofit: Retrofit) : API{
    private val api:API by lazy { retrofit.create(API::class.java) }

    override fun getUsers() = api.getUsers()
    override fun getPosts() = api.getPosts()
    override fun getAlbums() = api.getAlbums()
    override fun getPhotos() = api.getPhotos()
}