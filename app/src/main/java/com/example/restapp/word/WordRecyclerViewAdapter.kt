package com.example.restapp.word

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.restapp.R
import com.example.restapp.data.MealsItem

class WordRecyclerViewAdapter : RecyclerView.Adapter<WordRecyclerViewAdapter.WordViewHolder>() {

    private val mealsName: MutableList<MealsItem> = mutableListOf()

    fun setMealsName(meals: List<MealsItem>) {
        this.mealsName.clear()
        this.mealsName.addAll(meals)
        notifyDataSetChanged()
    }

    inner class WordViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.word_item_view, parent, false)
        return WordViewHolder(view)
    }

    override fun getItemCount() = mealsName.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val names = mealsName[position]
        holder.itemView.findViewById<Button>(R.id.button_word_item).text = names.name
    }
}