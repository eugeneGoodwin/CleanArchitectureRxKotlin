package com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore

import com.example.soft.cleanarchitecturerxkotlin.data.repository.Error
import com.example.soft.cleanarchitecturerxkotlin.domain.model.DUser
import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either
import io.reactivex.Observable

interface UserDataStore {
    fun users(): Observable<Either<Error, List<DUser>>>
    fun isExpired(): Boolean
}