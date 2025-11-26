package com.rose.ChuckNorrisApp.presenter

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import com.rose.ChuckNorrisApp.data.CategoryRemoteDataSource
import com.rose.ChuckNorrisApp.data.ListCategoryCallback
import com.rose.ChuckNorrisApp.model.Category
import com.rose.ChuckNorrisApp.view.CategoryItem
import com.rose.ChuckNorrisApp.view.HomeFragment
import java.util.concurrent.Delayed

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onSucess(response: List<String>) {
        val start = 54
        val end = 259
        val diff = (end - start) / response.size

        val categories = response.mapIndexed {index, s ->
            val hsl = floatArrayOf(
                start + (diff * index).toFloat(),
                100.0f,
                50.0f
            )

            Category(s, Color.HSVToColor(hsl).toLong())
        }

        view.showCategories(categories)

    }

    override fun onError(message: String) {
        view.showFailure(message)
    }

    override fun onComplete() {
        view.hideProgress()
    }

}
