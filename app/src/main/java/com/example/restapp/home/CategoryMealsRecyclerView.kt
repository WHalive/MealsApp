package com.example.restapp.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.restapp.HomeActivity
import com.example.restapp.R
import com.example.restapp.data.*
import com.example.restapp.databinding.CategoryMealsItemBinding
import com.example.restapp.meals.MealsFragment

class CategoryMealsRecyclerViewAdapter :
    RecyclerView.Adapter<CategoryMealsRecyclerViewAdapter.CategoryMealsViewHolder>() {

    private val categoryMeals: MutableList<MealsItem> = mutableListOf()
    fun setCategoryMeals(categoryMeals: List<MealsItem>) {
        this.categoryMeals.clear()
        this.categoryMeals.addAll(categoryMeals)
        notifyDataSetChanged()
    }

    inner class CategoryMealsViewHolder(private var binding: CategoryMealsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(categoryMeals: MealsItem) {
            binding.categoryMealsName.text = categoryMeals.name
            binding.categoryMealsImage.load(categoryMeals.image)
            binding.categoryMealsCardView.setOnClickListener { v ->
                val activity = v?.context
                val mealsFragment = MealsFragment.newInstance(categoryMeals)
                (activity as HomeActivity).supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, mealsFragment)
                    .addToBackStack("")
                    .commit()
            }
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

//val CategoryMealsItem.toMealsItem: MealsItem
//    get() = MealsItem(mealId = this.mealId, name = this.name)