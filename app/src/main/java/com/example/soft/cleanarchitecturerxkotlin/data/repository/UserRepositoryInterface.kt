package com.example.soft.cleanarchitecturerxkotlin.data.repository

import com.example.soft.cleanarchitecturerxkotlin.domain.model.DUser
import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either
import io.reactivex.Observable

interface UserRepositoryInterface {
    fun users(): Observable<Either<Error, List<DUser>>>
}