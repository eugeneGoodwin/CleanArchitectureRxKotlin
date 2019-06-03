package com.example.soft.cleanarchitecturerxkotlin.domain.executor

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}