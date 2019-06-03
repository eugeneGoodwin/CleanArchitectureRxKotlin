package com.example.soft.cleanarchitecturerxkotlin.data.repository

import com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.UserDataStoreFactory
import com.example.soft.cleanarchitecturerxkotlin.domain.model.DUser
import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either
import io.reactivex.Observable
import javax.inject.Inject


class UserRepository @Inject constructor(private val factory: UserDataStoreFactory) : UserRepositoryInterface {
    override fun users(): Observable<Either<Error, List<DUser>>> = factory.retrieveRemoteDataStore().users()
}