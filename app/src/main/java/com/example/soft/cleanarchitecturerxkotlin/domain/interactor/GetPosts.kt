package com.example.soft.cleanarchitecturerxkotlin.domain.interactor

import com.example.soft.cleanarchitecturerxkotlin.domain.model.DPost
import com.example.soft.cleanarchitecturerxkotlin.data.repository.PostRepositoryInterface
import com.example.soft.cleanarchitecturerxkotlin.domain.executor.PostExecutionThread
import com.example.soft.cleanarchitecturerxkotlin.domain.executor.ThreadExecutor
import com.example.soft.cleanarchitecturerxkotlin.utils.functional.Either
import com.example.soft.cleanarchitecturerxkotlin.data.repository.Error
import io.reactivex.Observable
import javax.inject.Inject

class GetPosts @Inject constructor(private val repository: PostRepositoryInterface,
                                   threadExecutor: ThreadExecutor,
                                   postExecutionThread: PostExecutionThread) : ObservableWithoutParamUseCase<Either<Error, List<DPost>>>(threadExecutor, postExecutionThread) {
    override fun build() : Observable<Either<Error, List<DPost>>> = repository.posts()
}