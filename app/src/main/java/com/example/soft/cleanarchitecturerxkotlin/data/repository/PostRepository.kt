package com.example.soft.cleanarchitecturerxkotlin.data.repository

import com.example.soft.cleanarchitecturerxkotlin.data.mapper.Mapper
import com.example.soft.cleanarchitecturerxkotlin.data.mapper.PostMapper
import com.example.soft.cleanarchitecturerxkotlin.data.model.Post
import com.example.soft.cleanarchitecturerxkotlin.data.repository.datastore.PostDataStoreFactory
import com.example.soft.cleanarchitecturerxkotlin.domain.model.DPost
import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either
import io.reactivex.Observable
import javax.inject.Inject

class PostRepository @Inject constructor(private val factory: PostDataStoreFactory) : PostRepositoryInterface {
    override fun posts(): Observable<Either<Error, List<DPost>>> = factory.retrieveRemoteDataStore().posts()
}