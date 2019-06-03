package com.example.soft.cleanarchitecturerxkotlin.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.soft.cleanarchitecturerxkotlin.data.repository.Error

open class BaseViewModel : ViewModel() {
    var failure : MutableLiveData<Error> = MutableLiveData()

    protected fun handleFailure(fail : Error) {
        this.failure.value = fail
    }
}