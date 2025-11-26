package com.rose.ChuckNorrisApp.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.rose.ChuckNorrisApp.R
import com.rose.ChuckNorrisApp.model.Category
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CategoryItem(val category: Category) : Item<CategoryItem.CategoryViewHolder>() {

    class CategoryViewHolder(view: View) : GroupieViewHolder(view)

    override fun createViewHolder(itemView: View) = CategoryViewHolder(itemView)

    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.item_category).text = category.name

        viewHolder.itemView.findViewById<LinearLayout>(R.id.container_category).setBackgroundColor(category.bgColor.toInt())
    }

    override fun getLayout() = R.layout.category_item
}