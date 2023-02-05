package com.example.restapp.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.restapp.R
import com.example.restapp.data.Meals
import com.example.restapp.data.MealsItem
import com.example.restapp.databinding.HomeImageItemViewBinding
import java.util.LinkedList


class MealsImageAdapter(private val listener: RecyclerViewEvent) :
    RecyclerView.Adapter<MealsImageAdapter.MealsImageHolder>() {

    private val meals: MutableList<MealsItem> = mutableListOf()


    fun setMeals(meals: List<MealsItem>) {
        this.meals.clear()
        this.meals.addAll(meals)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsImageHolder {
        return MealsImageHolder(HomeImageItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = meals.size

    override fun onBindViewHolder(holder: MealsImageHolder, position: Int) {
        val meals = meals[position]
        holder.bind(meals)
//        Log.d("TAG", "onBindViewHolder: $image")
//        holder.itemView.findViewById<ImageView>(R.id.home_recycler_view).load(image)
    }

    interface RecyclerViewEvent {
        fun onItemClick(position: Int)
    }

    inner class MealsImageHolder(private var binding: HomeImageItemViewBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(image: MealsItem) {
            val img = image.image
            binding.homeImageItem.load(img)
            val text = image.name
            binding.homeImageText.setText(text)

        }

        init {
            binding.homeImageItem.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
}
