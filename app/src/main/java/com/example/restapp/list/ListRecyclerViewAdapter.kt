package com.example.restapp.list

import android.os.Build
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.restapp.R
import com.example.restapp.databinding.ListItemViewBinding

class ListRecyclerViewAdapter : RecyclerView.Adapter<ListRecyclerViewAdapter.LetterViewHolder>() {

    private val list = ('A').rangeTo('Z').toList()

    inner class LetterViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return LetterViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val letters = list[position]
        holder.itemView.findViewById<Button>(R.id.button_item).text = letters.toString()
    }
}