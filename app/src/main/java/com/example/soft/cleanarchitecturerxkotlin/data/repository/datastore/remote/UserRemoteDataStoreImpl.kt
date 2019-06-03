package com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.remote

import com.example.soft.cleanarchitecturerxkotlin.data.mapper.UserMapper
import com.example.soft.cleanarchitecturerxkotlin.data.repository.Error
import com.example.soft.cleanarchitecturerxkotlin.data.repository.NetService
import com.example.soft.cleanarchitecturerxkotlin.data.repository.NetworkHandler
import com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.UserDataStore
import com.example.soft.cleanarchitecturerxkotlin.domain.model.DUser
import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either
import io.reactivex.Observable
import javax.inject.Inject

class UserRemoteDataStoreImpl @Inject constructor(private val networkHandler: NetworkHandler,
                                                  private val service: NetService,
                                                  private val mapper: UserMapper) : UserDataStore {
    override fun users(): Observable<Either<Error, List<DUser>>> {
        return when (networkHandler.isConnected) {
            true -> service.getUsers().doOnError{ Either.Left(Error.ServerError(it))}.
                    map { users ->
                        val dUsers = users.map{ mapper.mapFromEntity(it) }
                        Either.Right(dUsers)
                    }
            false, null -> Observable.just(Either.Left(Error.NetworkConnectionError("No connection")))
        }
    }

    override fun isExpired(): Boolean = false
}