package com.example.restapp.list

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.restapp.HomeActivity
import com.example.restapp.R
import com.example.restapp.meals.MealsFragment
import com.example.restapp.word.WordFragment

class ListRecyclerViewAdapter :
    RecyclerView.Adapter<ListRecyclerViewAdapter.LetterViewHolder>() {

    private val list = ('A').rangeTo('Z').toList()


    inner class LetterViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_list_item)

        init {
            button.setOnClickListener { v ->
                val activity = v!!.context as AppCompatActivity
                val bundle = Bundle()
                bundle.putString("button_text", button.text.toString())

                val wordFragment = WordFragment()
                wordFragment.arguments = bundle
                activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, wordFragment)
                    .addToBackStack("")
                    .commit()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return LetterViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val letters = list[position]
        holder.itemView.findViewById<Button>(R.id.button_list_item).text = letters.toString()
    }
}
