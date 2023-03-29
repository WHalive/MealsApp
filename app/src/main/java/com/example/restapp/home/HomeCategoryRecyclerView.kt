package com.example.restapp.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.blue
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.example.restapp.HomeActivity
import com.example.restapp.R
import com.example.restapp.data.MealsItem
import com.example.restapp.databinding.HomeCategoryItemViewBinding
import com.example.restapp.databinding.HomeImageItemViewBinding
import com.example.restapp.word.WordFragment
import com.google.android.material.card.MaterialCardView
import java.util.Locale.Category

class HomeCategoryRecyclerViewAdapter(private val ctx: Context) :
    RecyclerView.Adapter<HomeCategoryRecyclerViewAdapter.CategoryViewHolder>() {

    private val categoryItem: MutableList<MealsItem> = mutableListOf()

    fun setCategory(categories: List<MealsItem>) {
        this.categoryItem.clear()
        this.categoryItem.addAll(categories)
        notifyDataSetChanged()
    }
    private var selectedItemPosition: Int = 0
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
        fun bind(category: MealsItem) {
            binding.homeCategoryItemText.text = category.category
            openCategoryFragment(ctx, "beef")
            binding.homeCategoryItemText.setOnClickListener {
                selectedItemPosition = position
                notifyDataSetChanged()
                openCategoryFragment(ctx, binding.homeCategoryItemText.text.toString())
            }
            if(selectedItemPosition == position)
                binding.categoryCardView.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#00B1E5")))
            else
                binding.categoryCardView.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")))
        }
    }
    private fun openCategoryFragment(ctx: Context, words: String) {
        val categoryFragment = CategoryFragment.newInstance(words)
        (ctx as HomeActivity).supportFragmentManager
            .beginTransaction()
            .replace(R.id.homeFragmentContainer, categoryFragment)
            .addToBackStack("")
            .commit()
    }
}


