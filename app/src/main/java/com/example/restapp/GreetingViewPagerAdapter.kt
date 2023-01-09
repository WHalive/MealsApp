package com.example.restapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restapp.databinding.GreetingItemViewBinding

class GreetingViewPagerAdapter(
    private val context: Context,
    private val imageList: MutableList<Int>,
    private val textList: MutableList<String>,
    private val descriptionList: MutableList<String>
) : RecyclerView.Adapter<GreetingViewPagerAdapter.ViewPagerHolder>() {


    inner class ViewPagerHolder(private var greetingItemBinding: GreetingItemViewBinding) :
        RecyclerView.ViewHolder(greetingItemBinding.root) {
        @SuppressLint("ResourceType")
        fun bind(text: String, description: String, image: Int) {
            greetingItemBinding.ivGreetingText.text = text
            greetingItemBinding.ivGreetingTextDescription.text = description
            greetingItemBinding.ivGreetingImage.setImageResource(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val binding =
            GreetingItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPagerHolder(binding)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val text = textList[position]
        val description = descriptionList[position]
        val image = imageList[position]
        holder.bind(text, description, image)
    }

}

