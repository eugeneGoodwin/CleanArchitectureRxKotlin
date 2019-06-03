package com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.remote

import com.example.soft.cleanarchitecturerxkotlin.data.mapper.PostMapper
import com.example.soft.cleanarchitecturerxkotlin.data.repository.NetService
import com.example.soft.cleanarchitecturerxkotlin.data.repository.NetworkHandler
import com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.PostDataStore
import com.example.soft.cleanarchitecturerxkotlin.domain.model.DPost
import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either
import com.example.soft.cleanarchitecturerxkotlin.data.repository.Error
import io.reactivex.Observable
import javax.inject.Inject

class PostRemoteDataStoreImpl @Inject constructor(private val networkHandler: NetworkHandler,
                                                  private val service: NetService,
                                                  private val mapper: PostMapper) : PostDataStore {
    override fun posts(): Observable<Either<Error, List<DPost>>> {
        return when (networkHandler.isConnected) {
            true -> service.getPosts().doOnError{ Either.Left(Error.ServerError(it))}.
                    map { posts ->
                        val dPosts = posts.map{ mapper.mapFromEntity(it) }
                        Either.Right(dPosts)
                    }
            false, null -> Observable.just(Either.Left(Error.NetworkConnectionError("No connection")))
        }
    }

    override fun isExpired(): Boolean = false
}