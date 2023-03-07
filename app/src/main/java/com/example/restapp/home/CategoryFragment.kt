package com.example.restapp.home

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.restapp.R
import com.example.restapp.data.CategoryItem
import com.example.restapp.data.MealsItem
import com.example.restapp.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private lateinit var categoryItem: CategoryItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       categoryItem = arguments?.getParcelable("categoryObject")!!
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.categoryText.text = categoryItem.category
    }
    companion object {
        fun newInstance(categoryItem: CategoryItem): CategoryFragment {
            val args = Bundle().apply {
                putParcelable("categoryObject", categoryItem)
            }
            return CategoryFragment().apply {
                arguments = args
            }
        }
    }
}