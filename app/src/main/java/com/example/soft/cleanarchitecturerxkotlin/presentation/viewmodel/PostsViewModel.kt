package com.example.soft.cleanarchitecturerxkotlin.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.example.soft.cleanarchitecturerxkotlin.domain.interactor.GetPosts
import com.example.soft.cleanarchitecturerxkotlin.domain.model.DPost
import com.example.soft.cleanarchitecturerxkotlin.data.repository.Error
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class PostsViewModel @Inject constructor(private val getPosts : GetPosts) : BaseViewModel() {

    var posts : MutableLiveData<List<DPost>> = MutableLiveData()
    private var disposable: Disposable? = null

    fun loadPosts(){
        disposable = getPosts.execute().subscribe({ it.fold(::handleFailure, ::handlePostsList)}, { handleFailure(Error.UnknownRxError(it))})
    }

    private fun handlePostsList(dposts : List<DPost>) {
        this.posts.value = dposts
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }
}