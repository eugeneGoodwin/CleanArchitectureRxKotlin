package com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.db

import com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.PostDataStore
import com.example.soft.cleanarchitecturerxkotlin.domain.model.DPost
import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either
import com.example.soft.cleanarchitecturerxkotlin.data.repository.Error
import io.reactivex.Observable
import javax.inject.Inject

class PostDBDataStoreImpl @Inject constructor() : PostDataStore {

    override fun posts(): Observable<Either<Error, List<DPost>>> {
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