package com.example.soft.cleanarchitecturerxkotlin.domain.interactor

import com.example.soft.cleanarchitecturerxkotlin.domain.executor.PostExecutionThread
import com.example.soft.cleanarchitecturerxkotlin.domain.executor.ThreadExecutor
import io.reactivex.*
import io.reactivex.schedulers.Schedulers

abstract class UseCase protected constructor(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread)

abstract class UseCaseWithoutParam<out T>(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread
) : UseCase(threadExecutor, postExecutionThread) {
    abstract fun build(): T
    abstract fun execute(): T
}

abstract class UseCaseWithParam<out T, in P>(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread
) : UseCase(threadExecutor, postExecutionThread) {
    abstract fun build(param: P): T
    abstract fun execute(param: P): T
}

abstract class CompletableWithParamUseCase<in P>(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread
) : UseCaseWithParam<Completable, P>(threadExecutor, postExecutionThread)

abstract class CompletableUseCase(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) :
        UseCaseWithoutParam<Completable>(
                threadExecutor,
                postExecutionThread
        )

abstract class ObservableWithParamUseCase<T, in P>(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread
) : UseCaseWithParam<Observable<T>, P>(threadExecutor, postExecutionThread) {
    override fun execute(param: P): Observable<T> {
        return build(param)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
    }
}

abstract class ObservableWithoutParamUseCase<T>(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread
) : UseCaseWithoutParam<Observable<T>>(threadExecutor, postExecutionThread) {
    override fun execute(): Observable<T> {
        return build()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
    }
}

abstract class SingleWithParamUseCase<T, in P>(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread
) : UseCaseWithParam<Single<T>, P>(threadExecutor, postExecutionThread) {

}

abstract class SingleUseCase<T>(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread
) : UseCaseWithoutParam<Single<T>>(threadExecutor, postExecutionThread)

abstract class MaybeWithParamUseCase<T, in P>(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread
) : UseCaseWithParam<Maybe<T>, P>(threadExecutor, postExecutionThread) {

    override fun execute(param: P): Maybe<T> {
        return build(param).subscribeOn(Schedulers.from(threadExecutor))
                           .observeOn(postExecutionThread.scheduler)
    }
}

abstract class MaybeUseCase<T>(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread
) : UseCaseWithoutParam<Maybe<T>>(threadExecutor, postExecutionThread) {
    override fun execute(): Maybe<T> =
            build().subscribeOn(Schedulers.from(threadExecutor))
                    .observeOn(postExecutionThread.scheduler)

}

abstract class FlowableWithParamUseCase<T, in P>(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread
) : UseCaseWithParam<Flowable<T>, P>(threadExecutor, postExecutionThread)

abstract class FlowableUseCase<StreamT>(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) :
        UseCaseWithoutParam<Flowable<StreamT>>(threadExecutor, postExecutionThread)