package com.example.restapp.meals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.restapp.R
import com.example.restapp.databinding.FragmentMealsBinding
import com.example.restapp.databinding.FragmentWordBinding


class MealsFragment : Fragment() {

    private lateinit var binding: FragmentMealsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMealsBinding.inflate(inflater, container, false)
        binding.mealsName.text = arguments?.getString("text").toString()

        return binding.root
    }

}