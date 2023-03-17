package com.example.restapp.word

import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.restapp.HomeActivity
import com.example.restapp.R
import com.example.restapp.data.Meals
import com.example.restapp.data.MealsItem
import com.example.restapp.meals.MealsFragment


class WordRecyclerViewAdapter : RecyclerView.Adapter<WordRecyclerViewAdapter.WordViewHolder>() {

    private val mealsName: MutableList<MealsItem> = mutableListOf()

    fun setMealsName(meals: List<MealsItem>) {
        this.mealsName.clear()
        this.mealsName.addAll(meals)
        notifyDataSetChanged()
    }

    inner class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val button: Button = view.findViewById(R.id.button_word_item)

        fun bind(mealsItem: MealsItem) {
            button.text = mealsItem.name
            button.setOnClickListener { v ->
                val activity = v?.context
                Log.d("word", "bind: $mealsItem")
                val mealFragment = MealsFragment.newInstance(mealsItem)
                (activity as HomeActivity).supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, mealFragment)
                    .addToBackStack("")
                    .commit()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordRecyclerViewAdapter.WordViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.word_item_view, parent, false)
        return WordViewHolder(view)
    }

    override fun getItemCount() = mealsName.size

    override fun onBindViewHolder(holder: WordRecyclerViewAdapter.WordViewHolder, position: Int) {
        val mealItem = mealsName[position]
        holder.bind(mealItem)
    }
}