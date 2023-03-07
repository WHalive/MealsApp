package com.example.restapp.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restapp.data.CategoryItem
import com.example.restapp.data.MealsCategory
import com.example.restapp.data.MealsItem
import com.example.restapp.databinding.HomeCategoryItemViewBinding
import com.example.restapp.databinding.HomeImageItemViewBinding
import java.util.Locale.Category

class HomeCategoryRecyclerViewAdapter :
    RecyclerView.Adapter<HomeCategoryRecyclerViewAdapter.CategoryViewHolder>() {

    private val categoryItem: MutableList<CategoryItem> = mutableListOf()

    fun setCategory(categories: List<CategoryItem>) {
        this.categoryItem.clear()
        this.categoryItem.addAll(categories)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(HomeCategoryItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = categoryItem.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryItem[position]
        
        holder.bind(category)
    }

    inner class CategoryViewHolder(private var binding: HomeCategoryItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: CategoryItem) {
            val text = category.category
            binding.homeCategoryItemText.text = text
        }
    }
}