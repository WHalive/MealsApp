package com.example.restapp.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.restapp.R
import com.example.restapp.data.MealsItem
import com.example.restapp.databinding.HomeImageItemViewBinding

//class HomeViewPagerAdapter : RecyclerView.Adapter<HomeViewPagerAdapter.ViewPagerViewHolder>() {
//
//    private val meals: MutableList<MealsItem> = mutableListOf()
//
//    inner class ViewPagerViewHolder(itemView: View) :
//        RecyclerView.ViewHolder(itemView)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
//
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.home_image_item_view, parent, false)
//        return ViewPagerViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return meals.size
//    }
//
//    @SuppressLint("SuspiciousIndentation")
//    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
//        val image = meals[position].image
//        holder.itemView.findViewById<ImageView>(R.id.home_image_view_pager).load(image)
//    }
//
//    fun setMealsImage(mealsImage: List<MealsItem>) {
//        meals.clear()
//        meals.addAll(mealsImage)
//        Log.d("HomeViewModel", "setImages:${meals.size}")
//    }
//}