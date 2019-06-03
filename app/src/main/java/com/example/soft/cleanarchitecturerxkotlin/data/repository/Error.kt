package com.example.soft.cleanarchitecturerxkotlin.data.repository

import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either

sealed class Error {
    val failure: Either<Throwable, String>

    constructor(error_message: String) {
        failure = Either.Right(error_message)
    }
    constructor(exception: Throwable) {
        failure = Either.Left(exception)
    }

    fun getMessage(): String {
        var errorMessage: String = ""
        failure.fold({
            errorMessage = it.message ?: ""
        }, {
            errorMessage = it
        })
        return errorMessage
    }

    class NetworkConnectionError: Error {
        constructor(error_message: String) : super(error_message)
        constructor(exception: Throwable) : super(exception)
    }
    class ServerError: Error {
        constructor(error_message: String) : super(error_message)
        constructor(exception: Throwable) : super(exception)
    }
    class UnknownRxError: Error {
        constructor(error_message: String) : super(error_message)
        constructor(exception: Throwable) : super(exception)
    }
}