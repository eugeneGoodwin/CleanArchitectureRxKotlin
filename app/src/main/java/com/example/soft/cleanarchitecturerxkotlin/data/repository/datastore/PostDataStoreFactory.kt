package com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore

open class PostDataStoreFactory (private val remotePostDataStore: PostDataStore,
                            private val dbPostDataStore: PostDataStore) {
    open fun retrieveDataStore(isCashed:Boolean): PostDataStore = if(isCashed && !dbPostDataStore.isExpired()) dbPostDataStore else remotePostDataStore
    open fun retrieveRemoteDataStore(): PostDataStore = remotePostDataStore
    open fun retrieveDbDataStore(): PostDataStore = dbPostDataStore
}