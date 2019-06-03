package com.example.soft.cleanarchitecturerxkotlin.data.repository

import com.example.soft.cleanarchitecturerxkotlin.domain.model.DPost
import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either
import io.reactivex.Observable

interface PostRepositoryInterface {
    fun posts(): Observable<Either<Error, List<DPost>>>
}