package com.rose.ChuckNorrisApp.presenter

import com.rose.ChuckNorrisApp.view.JokeFragment
import com.rose.ChuckNorrisApp.data.CategoryRemoteDataSource
import com.rose.ChuckNorrisApp.data.JokeCallback
import com.rose.ChuckNorrisApp.data.JokeDayRemoteDataSource
import com.rose.ChuckNorrisApp.data.JokeRemoteDataSource
import com.rose.ChuckNorrisApp.model.Joke
import com.rose.ChuckNorrisApp.view.JokeDayFragment

class JokeDayPresenter(
    private val view: JokeDayFragment,
    private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()
) : JokeCallback{

    fun findRandom(){
        view.showProgress()
        dataSource.findRandom(this)
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