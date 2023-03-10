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
import com.example.restapp.R
import com.example.restapp.data.CategoryItem
import com.example.restapp.data.CategoryMealsItem
import com.example.restapp.data.MealsItem
import com.example.restapp.databinding.FragmentCategoryBinding
import com.example.restapp.viewModel.ViewModel

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private val viewModel: ViewModel by viewModels()
//    private lateinit var words: String
    private val categoryMealsAdapter by lazy { CategoryMealsRecyclerViewAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        words = arguments?.getParcelable("categoryObject")!!
//        words = arguments?.getString("category_text").toString()
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        binding.categoryMealsRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.categoryMealsRecyclerView.adapter = categoryMealsAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val words = "Seafood"
        viewModel.categoryMealsByWords(words)
        viewModel.categoryMeals.observe(viewLifecycleOwner) { meals ->
            categoryMealsAdapter.setCategoryMeals(meals)
            Log.d("CategoryFragment", "onViewCreated: $meals")
        }

    }

    companion object {
        fun newInstance() = CategoryFragment()
//        fun newInstance(categoryItem: CategoryItem): CategoryFragment {
//            val args = Bundle().apply {
//                putParcelable("categoryObject", categoryItem)
//            }
//            return CategoryFragment().apply {
//                arguments = args
//            }
//        }
    }
}