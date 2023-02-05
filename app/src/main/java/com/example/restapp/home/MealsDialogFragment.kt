package com.example.restapp.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.restapp.R
import com.example.restapp.data.MealsItem
import com.example.restapp.databinding.FragmentMealsDialogBinding


class MealsDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentMealsDialogBinding
    private val videoViewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMealsDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        videoViewModel.meals.observe(viewLifecycleOwner){

        }

    }
}

