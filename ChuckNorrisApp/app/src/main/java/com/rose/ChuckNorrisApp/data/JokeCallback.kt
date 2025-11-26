package com.rose.ChuckNorrisApp.data

import com.rose.ChuckNorrisApp.model.Category
import com.rose.ChuckNorrisApp.model.Joke

interface JokeCallback {

    fun onSucess(response: Joke)
    fun onError(message: String)
    fun onComplete()
}