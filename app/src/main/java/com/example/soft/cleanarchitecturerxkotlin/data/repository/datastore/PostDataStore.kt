package com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore

import com.example.soft.cleanarchitecturerxkotlin.data.repository.Error
import com.example.soft.cleanarchitecturerxkotlin.domain.model.DPost
import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either
import io.reactivex.Observable

interface PostDataStore {
    fun posts(): Observable<Either<Error, List<DPost>>>
    fun isExpired(): Boolean
}