package com.example.soft.cleanarchitecturerxkotlin.data.repository

import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either
import retrofit2.Call
import com.example.soft.cleanarchitecturerxkotlin.data.repository.Error.ServerError

open class NetworkRepository {
    protected fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Error, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Either.Right(transform((response.body() ?: default)))
                false -> Either.Left(ServerError(response.errorBody()?.toString() ?: ""))
            }
        } catch (exception: Throwable) {
            Either.Left(ServerError(exception))
        }
    }

}