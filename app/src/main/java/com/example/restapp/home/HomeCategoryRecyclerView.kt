package com.example.restapp.home

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.blue
import androidx.recyclerview.widget.RecyclerView
import com.example.restapp.HomeActivity
import com.example.restapp.R
import com.example.restapp.data.CategoryItem
import com.example.restapp.data.MealsCategory
import com.example.restapp.data.MealsItem
import com.example.restapp.databinding.HomeCategoryItemViewBinding
import com.example.restapp.databinding.HomeImageItemViewBinding
import com.example.restapp.word.WordFragment
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
            binding.homeCategoryItemText.text = category.category
            binding.homeCategoryItemText.setOnClickListener { v ->
                binding.categoryCardView.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#00B1E5")))
                val activity = v!!.context
                val categoryFragment = CategoryFragment.newInstance(binding.homeCategoryItemText.text.toString())
                (activity as HomeActivity).supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.homeFragmentContainer, categoryFragment)
                    .addToBackStack("")
                    .commit()
            }
        }
    }
}