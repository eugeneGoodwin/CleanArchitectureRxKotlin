package com.example.soft.cleanarchitecturerxkotlin.domain.interactor

import com.example.soft.cleanarchitecturerxkotlin.data.repository.UserRepositoryInterface
import com.example.soft.cleanarchitecturerxkotlin.domain.executor.PostExecutionThread
import com.example.soft.cleanarchitecturerxkotlin.domain.executor.ThreadExecutor
import com.example.soft.cleanarchitecturerxkotlin.domain.model.DUser
import com.example.soft.cleanarchitecturerxkotlin.data.repository.Error
import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either
import io.reactivex.Observable
import javax.inject.Inject

class GetUsers @Inject constructor(private val repository: UserRepositoryInterface,
                                   threadExecutor: ThreadExecutor,
                                   postExecutionThread: PostExecutionThread) : ObservableWithoutParamUseCase<Either<Error, List<DUser>>>(threadExecutor, postExecutionThread) {
    override fun build() : Observable<Either<Error, List<DUser>>> = repository.users()
}