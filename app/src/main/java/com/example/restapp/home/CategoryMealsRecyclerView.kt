package com.example.restapp.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.restapp.data.CategoryMealsItem
import com.example.restapp.databinding.CategoryMealsItemBinding

class CategoryMealsRecyclerViewAdapter :
    RecyclerView.Adapter<CategoryMealsRecyclerViewAdapter.CategoryMealsViewHolder>() {

    private val categoryMeals: MutableList<CategoryMealsItem> = mutableListOf()
    fun setCategoryMeals(categoryMeals: List<CategoryMealsItem>) {
        this.categoryMeals.clear()
        this.categoryMeals.addAll(categoryMeals)
        notifyDataSetChanged()
    }

    inner class CategoryMealsViewHolder(private var binding: CategoryMealsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(categoryMeals: CategoryMealsItem) {
            binding.categoryMealsName.text = categoryMeals.name
            binding.categoryMealsImage.load(categoryMeals.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMealsViewHolder {
        return CategoryMealsViewHolder(CategoryMealsItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = categoryMeals.size

    override fun onBindViewHolder(holder: CategoryMealsViewHolder, position: Int) {
        val categoryMeals = categoryMeals[position]
        holder.bind(categoryMeals)
    }
}