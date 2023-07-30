package com.demo.tpzoo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.demo.tpzoo.databinding.CategoryBinding
import com.demo.tpzoo.model.CategoryInfo
import androidx.databinding.library.baseAdapters.BR
import com.demo.tpzoo.R

class CategoryListAdapter(
    private val onClickListener: View.OnClickListener
) :
    ListAdapter<CategoryInfo, CategoryListViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<CategoryInfo>() {
        override fun areItemsTheSame(oldItem: CategoryInfo, newItem: CategoryInfo) = (oldItem == newItem)

        override fun areContentsTheSame(oldItem: CategoryInfo, newItem: CategoryInfo) = (oldItem == newItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryListViewHolder(
            DataBindingUtil.inflate<CategoryBinding>(
                LayoutInflater.from(parent.context), viewType, parent, false
            ).apply {
                root.setOnClickListener(onClickListener)
            }
        )

    override fun getItemViewType(position: Int) = R.layout.category

    fun getCategoryInfo(position: Int): CategoryInfo = getItem(position)

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        holder.categoryBinding.setVariable(BR.category , getItem(position))
    }
}

open class CategoryListViewHolder(var categoryBinding: CategoryBinding) :
    RecyclerView.ViewHolder(categoryBinding.root)
