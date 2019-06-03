package com.example.soft.cleanarchitecturerxkotlin.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.example.soft.cleanarchitecturerxkotlin.data.repository.Error
import com.example.soft.cleanarchitecturerxkotlin.domain.interactor.GetUsers
import com.example.soft.cleanarchitecturerxkotlin.domain.model.DUser
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class UsersViewModel @Inject constructor(private val getUsers : GetUsers) : BaseViewModel() {

    var users : MutableLiveData<List<DUser>> = MutableLiveData()
    private var disposable: Disposable? = null

    fun loadUsers(){
        disposable = getUsers.execute().subscribe({ it.fold(::handleFailure, ::handleUsersList)}, { handleFailure(Error.UnknownRxError(it))})
    }

    private fun handleUsersList(dusers : List<DUser>) {
        this.users.value = dusers
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }
}