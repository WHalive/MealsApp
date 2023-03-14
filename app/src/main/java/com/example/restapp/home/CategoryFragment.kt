package com.example.restapp.home

import android.os.Binder
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapp.data.MealsItem
import com.example.restapp.databinding.FragmentCategoryBinding
import com.example.restapp.meals.MealsFragment
import com.example.restapp.viewModel.ViewModel

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private val viewModel: ViewModel by viewModels()
    private lateinit var words : String
    private val categoryMealsAdapter by lazy { CategoryMealsRecyclerViewAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        words = arguments?.getString("categoryMeals").toString()
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        binding.categoryMealsRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.categoryMealsRecyclerView.adapter = categoryMealsAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.categoryMealsByWords(words)
        viewModel.categoryMeals.observe(viewLifecycleOwner) { meals ->
            categoryMealsAdapter.setCategoryMeals(meals)
        }
    }

    companion object {
        fun newInstance(words: String): CategoryFragment {
            val args = Bundle().apply {
                putString("categoryMeals", words)
            }
            return CategoryFragment().apply {
                arguments = args
            }
        }
    }
}