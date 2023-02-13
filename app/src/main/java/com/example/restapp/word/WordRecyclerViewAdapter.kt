package com.example.restapp.word

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.example.restapp.R
import com.example.restapp.data.MealsItem
import com.example.restapp.home.MealsImageAdapter
import com.example.restapp.list.ListRecyclerViewAdapter
import com.example.restapp.meals.MealsFragment

class WordRecyclerViewAdapter : RecyclerView.Adapter<WordRecyclerViewAdapter.WordViewHolder>() {

    private val mealsName: MutableList<MealsItem> = mutableListOf()

    fun setMealsName(meals: List<MealsItem>) {
        this.mealsName.clear()
        this.mealsName.addAll(meals)
        notifyDataSetChanged()
    }

    inner class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_word_item)

        init {
            button.setOnClickListener { v ->
                val activity = v!!.context as AppCompatActivity
                val bundle = Bundle()
                bundle.putString("text", button.text.toString())

                val mealFragment = MealsFragment()
                mealFragment.arguments = bundle
                activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, mealFragment)
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
        val names = mealsName[position]
        holder.itemView.findViewById<Button>(R.id.button_word_item).text = names.name

    }
}