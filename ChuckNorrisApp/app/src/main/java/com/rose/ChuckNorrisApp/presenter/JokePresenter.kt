package com.rose.ChuckNorrisApp.presenter

import com.rose.ChuckNorrisApp.view.JokeFragment
import com.rose.ChuckNorrisApp.data.CategoryRemoteDataSource
import com.rose.ChuckNorrisApp.data.JokeCallback
import com.rose.ChuckNorrisApp.data.JokeRemoteDataSource
import com.rose.ChuckNorrisApp.model.Joke

class JokePresenter(
    private val view: JokeFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback{

    fun findBy(categoryName: String){
        view.showProgress()
        dataSource.findBy(categoryName, this)
    }

    override fun onSucess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(message: String) {
        view.showFailure(message)
    }

    override fun onComplete() {
        view.hideProgress()
    }
}