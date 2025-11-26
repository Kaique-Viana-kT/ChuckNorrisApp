package com.rose.ChuckNorrisApp.data

import com.rose.ChuckNorrisApp.model.Category

interface ListCategoryCallback {

    fun onSucess(response: List<String>)
    fun onError(message: String)
    fun onComplete()
}