package com.example.restapp.meals

import android.annotation.SuppressLint
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
        binding.mealsAreaName.text = mealsItem.area
        binding.mealsCategoryName.text = mealsItem.type

        binding.ing1.text = mealsItem.ing1
        binding.m1.text = mealsItem.m1

        binding.ing2.text = mealsItem.ing2
        binding.m2.text = mealsItem.m2

        binding.ing3.text = mealsItem.ing3
        binding.m3.text = mealsItem.m3

        binding.ing4.text = mealsItem.ing4
        binding.m4.text = mealsItem.m4

        binding.ing5.text = mealsItem.ing5
        binding.m5.text = mealsItem.m5

        binding.ing6.text = mealsItem.ing6
        binding.m6.text = mealsItem.m6

        binding.ing7.text = mealsItem.ing7
        binding.m7.text = mealsItem.m7

        binding.ing8.text = mealsItem.ing8
        binding.m8.text = mealsItem.m8

        binding.ing9.text = mealsItem.ing9
        binding.m9.text = mealsItem.m9

        binding.ing10.text = mealsItem.ing10
        binding.m10.text = mealsItem.m10

        binding.ing11.text = mealsItem.ing11
        binding.m11.text = mealsItem.m11

        binding.ing12.text = mealsItem.ing12
        binding.m12.text = mealsItem.m12

        binding.ing13.text = mealsItem.ing13
        binding.m13.text = mealsItem.m13

        binding.ing14.text = mealsItem.ing14
        binding.m14.text = mealsItem.m14

        binding.ing15.text = mealsItem.ing15
        binding.m15.text = mealsItem.m15

        binding.ing16.text = mealsItem.ing16
        binding.m16.text = mealsItem.m16

        binding.ing17.text = mealsItem.ing17
        binding.m17.text = mealsItem.m17

        binding.ing18.text = mealsItem.ing18
        binding.m18.text = mealsItem.m18

        binding.ing19.text = mealsItem.ing19
        binding.m19.text = mealsItem.m19

        binding.ing20.text = mealsItem.ing20
        binding.m20.text = mealsItem.m20

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