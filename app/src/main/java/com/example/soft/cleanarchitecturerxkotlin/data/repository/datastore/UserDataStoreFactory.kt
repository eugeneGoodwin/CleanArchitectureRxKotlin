package com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore

open class UserDataStoreFactory (private val remoteUserDataStore: UserDataStore,
                            private val dbUserDataStore: UserDataStore) {
    open fun retrieveDataStore(isCashed:Boolean): UserDataStore = if(isCashed && !dbUserDataStore.isExpired()) dbUserDataStore else remoteUserDataStore
    open fun retrieveRemoteDataStore(): UserDataStore = remoteUserDataStore
    open fun retrieveDbDataStore(): UserDataStore = dbUserDataStore
}