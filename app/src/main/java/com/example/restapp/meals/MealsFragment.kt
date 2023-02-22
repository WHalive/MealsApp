package com.example.restapp.meals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.rangeTo
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.restapp.R
import com.example.restapp.data.Meals
import com.example.restapp.data.MealsItem
import com.example.restapp.databinding.FragmentMealsBinding
import com.example.restapp.databinding.FragmentWordBinding
import com.example.restapp.viewModel.ViewModel
import kotlin.properties.Delegates


class MealsFragment : Fragment() {

    private lateinit var binding: FragmentMealsBinding
    private lateinit var mealsItem: MealsItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mealsItem = arguments?.getParcelable("mealObject")!!
        binding = FragmentMealsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mealsName.text = mealsItem.name
        binding.mealsInstructionText.text = mealsItem.instruction
    }

    companion object {
        fun newInstance(mealsItem: MealsItem): MealsFragment {
            val args = Bundle().apply {
                putParcelable("mealObject", mealsItem)
            }
            return MealsFragment().apply {
                arguments = args
            }
        }
    }
}