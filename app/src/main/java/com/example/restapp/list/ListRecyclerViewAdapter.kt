package com.example.restapp.list

import android.os.Build
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.restapp.HomeActivity
import com.example.restapp.R

class ListRecyclerViewAdapter(
    private val listener: RecyclerViewEvent
) :
    RecyclerView.Adapter<ListRecyclerViewAdapter.LetterViewHolder>() {

    private val list = ('A').rangeTo('Z').toList()

    interface RecyclerViewEvent {
        fun onItemClick(position: Int)
    }

    inner class LetterViewHolder(view: View) :
        RecyclerView.ViewHolder(view), View.OnClickListener {
        val button = view.findViewById<Button>(R.id.button_list_item)

        init {
            button.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
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
