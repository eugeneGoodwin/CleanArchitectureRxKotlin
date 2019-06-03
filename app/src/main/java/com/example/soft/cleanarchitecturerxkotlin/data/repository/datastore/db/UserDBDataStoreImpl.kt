package com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.db

import com.example.soft.cleanarchitecturerxkotlin.data.repository.Error
import com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.UserDataStore
import com.example.soft.cleanarchitecturerxkotlin.domain.model.DUser
import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either
import io.reactivex.Observable
import javax.inject.Inject

class UserDBDataStoreImpl @Inject constructor() : UserDataStore {

    override fun users(): Observable<Either<Error, List<DUser>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        /*  val currentTime = System.currentTimeMillis()
            val lastUpdateTime = this.getLastCacheUpdateTimeMillis()
            return currentTime - lastUpdateTime > EXPIRATION_TIME
            */
    }
}