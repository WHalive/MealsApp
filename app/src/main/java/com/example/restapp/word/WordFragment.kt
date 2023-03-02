package com.example.restapp.word

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapp.R
import com.example.restapp.data.Meals
import com.example.restapp.data.MealsItem
import com.example.restapp.databinding.FragmentWordBinding
import com.example.restapp.list.ListRecyclerViewAdapter
import com.example.restapp.meals.MealsFragment
import com.example.restapp.viewModel.ViewModel
import kotlin.concurrent.fixedRateTimer

class WordFragment : Fragment() {

    private lateinit var binding: FragmentWordBinding
    private val viewModel: ViewModel by viewModels()
    private lateinit var letter: String
    private val wordAdapter by lazy { WordRecyclerViewAdapter() }

    companion object {
        fun newInstance() = WordFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        letter = arguments?.getString("button_text").toString()
        binding = FragmentWordBinding.inflate(inflater, container, false)
        binding.wordRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.wordRecyclerView.adapter = wordAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.mealsNameByLetter(letter)
        viewModel.mealsName.observe(viewLifecycleOwner) {
            wordAdapter.setMealsName(it)
        }
    }
}