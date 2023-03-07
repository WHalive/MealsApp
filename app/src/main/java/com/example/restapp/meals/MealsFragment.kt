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
import coil.load
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
        binding.mealsImage.load(mealsItem.image)

        binding.ing1.text = mealsItem.ing1
        binding.m1.text = mealsItem.m1
        if (mealsItem.m1.isNullOrEmpty() && mealsItem.ing1.isNullOrEmpty()) {
            binding.c1.visibility = View.GONE
        } else {
            binding.c1.visibility = View.VISIBLE
        }

        binding.ing2.text = mealsItem.ing2
        binding.m2.text = mealsItem.m2
        if (mealsItem.m2.isNullOrEmpty() && mealsItem.ing2.isNullOrEmpty()) {
            binding.c2.visibility = View.GONE
        } else {
            binding.c2.visibility = View.VISIBLE
        }

        binding.ing3.text = mealsItem.ing3
        binding.m3.text = mealsItem.m3
        if (mealsItem.m3.isNullOrEmpty() && mealsItem.ing3.isNullOrEmpty()) {
            binding.c3.visibility = View.GONE
        } else {
            binding.c3.visibility = View.VISIBLE
        }

        binding.ing4.text = mealsItem.ing4
        binding.m4.text = mealsItem.m4
        if (mealsItem.m4.isNullOrEmpty() && mealsItem.ing4.isNullOrEmpty()) {
            binding.c4.visibility = View.GONE
        } else {
            binding.c4.visibility = View.VISIBLE
        }

        binding.ing5.text = mealsItem.ing5
        binding.m5.text = mealsItem.m5
        if (mealsItem.m5.isNullOrEmpty() && mealsItem.ing5.isNullOrEmpty()) {
            binding.c5.visibility = View.GONE
        } else {
            binding.c5.visibility = View.VISIBLE
        }

        binding.ing6.text = mealsItem.ing6
        binding.m6.text = mealsItem.m6
        if (mealsItem.m6.isNullOrEmpty() && mealsItem.ing6.isNullOrEmpty()) {
            binding.c6.visibility = View.GONE
        } else {
            binding.c6.visibility = View.VISIBLE
        }

        binding.ing7.text = mealsItem.ing7
        binding.m7.text = mealsItem.m7
        if (mealsItem.m7.isNullOrEmpty() && mealsItem.ing7.isNullOrEmpty()) {
            binding.c7.visibility = View.GONE
        } else {
            binding.c7.visibility = View.VISIBLE
        }

        binding.ing8.text = mealsItem.ing8
        binding.m8.text = mealsItem.m8
        if (mealsItem.m8.isNullOrEmpty() && mealsItem.ing8.isNullOrEmpty()) {
            binding.c8.visibility = View.GONE
        } else {
            binding.c8.visibility = View.VISIBLE
        }

        binding.ing9.text = mealsItem.ing9
        binding.m9.text = mealsItem.m9
        if (mealsItem.m9.isNullOrEmpty() && mealsItem.ing9.isNullOrEmpty()) {
            binding.c9.visibility = View.GONE
        } else {
            binding.c9.visibility = View.VISIBLE
        }

        binding.ing10.text = mealsItem.ing10
        binding.m10.text = mealsItem.m10
        if (mealsItem.m10.isNullOrEmpty() && mealsItem.ing10.isNullOrEmpty()) {
            binding.c10.visibility = View.GONE
        } else {
            binding.c10.visibility = View.VISIBLE
        }

        binding.ing11.text = mealsItem.ing11
        binding.m11.text = mealsItem.m11
        if (mealsItem.m11.isNullOrEmpty() && mealsItem.ing11.isNullOrEmpty()) {
            binding.c11.visibility = View.GONE
        } else {
            binding.c11.visibility = View.VISIBLE
        }

        binding.ing12.text = mealsItem.ing12
        binding.m12.text = mealsItem.m12
        if (mealsItem.m12.isNullOrEmpty() && mealsItem.ing12.isNullOrEmpty()) {
            binding.c12.visibility = View.GONE
        } else {
            binding.c12.visibility = View.VISIBLE
        }

        binding.ing13.text = mealsItem.ing13
        binding.m13.text = mealsItem.m13
        if (mealsItem.m13.isNullOrEmpty() && mealsItem.ing13.isNullOrEmpty()) {
            binding.c13.visibility = View.GONE
        } else {
            binding.c13.visibility = View.VISIBLE
        }

        binding.ing14.text = mealsItem.ing14
        binding.m14.text = mealsItem.m14
        if (mealsItem.m14.isNullOrEmpty() && mealsItem.ing14.isNullOrEmpty()) {
            binding.c14.visibility = View.GONE
        } else {
            binding.c14.visibility = View.VISIBLE
        }

        binding.ing15.text = mealsItem.ing15
        binding.m15.text = mealsItem.m15
        if (mealsItem.m15.isNullOrEmpty() && mealsItem.ing15.isNullOrEmpty()) {
            binding.c15.visibility = View.GONE
        } else {
            binding.c15.visibility = View.VISIBLE
        }

        binding.ing16.text = mealsItem.ing16
        binding.m16.text = mealsItem.m16
        if (mealsItem.m16.isNullOrEmpty() && mealsItem.ing16.isNullOrEmpty()) {
            binding.c16.visibility = View.GONE
        } else {
            binding.c16.visibility = View.VISIBLE
        }

        binding.ing17.text = mealsItem.ing17
        binding.m17.text = mealsItem.m17
        if (mealsItem.m17.isNullOrEmpty() && mealsItem.ing17.isNullOrEmpty()) {
            binding.c17.visibility = View.GONE
        } else {
            binding.c17.visibility = View.VISIBLE
        }

        binding.ing18.text = mealsItem.ing18
        binding.m18.text = mealsItem.m18
        if (mealsItem.m18.isNullOrEmpty() && mealsItem.ing18.isNullOrEmpty()) {
            binding.c18.visibility = View.GONE
        } else {
            binding.c18.visibility = View.VISIBLE
        }

        binding.ing19.text = mealsItem.ing19
        binding.m19.text = mealsItem.m19
        if (mealsItem.m19.isNullOrEmpty() && mealsItem.ing19.isNullOrEmpty()) {
            binding.c19.visibility = View.GONE
        } else {
            binding.c19.visibility = View.VISIBLE
        }

        binding.ing20.text = mealsItem.ing20
        binding.m20.text = mealsItem.m20
        if (mealsItem.m20.isNullOrEmpty() && mealsItem.ing20.isNullOrEmpty()) {
            binding.c20.visibility = View.GONE
        } else {
            binding.c20.visibility = View.VISIBLE
        }

//        binding.ing1.text = mealsItem.ing1
//        binding.m1.text = mealsItem.m1
//
//        binding.ing2.text = mealsItem.ing2
//        binding.m2.text = mealsItem.m2
//
//        binding.ing3.text = mealsItem.ing3
//        binding.m3.text = mealsItem.m3
//
//        binding.ing4.text = mealsItem.ing4
//        binding.m4.text = mealsItem.m4
//
//        binding.ing5.text = mealsItem.ing5
//        binding.m5.text = mealsItem.m5
//
//        binding.ing6.text = mealsItem.ing6
//        binding.m6.text = mealsItem.m6
//
//        binding.ing7.text = mealsItem.ing7
//        binding.m7.text = mealsItem.m7
//
//        binding.ing8.text = mealsItem.ing8
//        binding.m8.text = mealsItem.m8
//
//        binding.ing9.text = mealsItem.ing9
//        binding.m9.text = mealsItem.m9
//
//        binding.ing10.text = mealsItem.ing10
//        binding.m10.text = mealsItem.m10
//
//        binding.ing11.text = mealsItem.ing11
//        binding.m11.text = mealsItem.m11
//
//        binding.ing12.text = mealsItem.ing12
//        binding.m12.text = mealsItem.m12
//
//        binding.ing13.text = mealsItem.ing13
//        binding.m13.text = mealsItem.m13
//
//        binding.ing14.text = mealsItem.ing14
//        binding.m14.text = mealsItem.m14
//
//        binding.ing15.text = mealsItem.ing15
//        binding.m15.text = mealsItem.m15
//
//        binding.ing16.text = mealsItem.ing16
//        binding.m16.text = mealsItem.m16
//
//        binding.ing17.text = mealsItem.ing17
//        binding.m17.text = mealsItem.m17
//
//        binding.ing18.text = mealsItem.ing18
//        binding.m18.text = mealsItem.m18
//
//        binding.ing19.text = mealsItem.ing19
//        binding.m19.text = mealsItem.m19
//
//        binding.ing20.text = mealsItem.ing20
//        binding.m20.text = mealsItem.m20


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