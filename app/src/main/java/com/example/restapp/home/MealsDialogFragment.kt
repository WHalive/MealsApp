package com.example.restapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.restapp.databinding.FragmentMealsDialogBinding
import com.example.restapp.viewModel.ViewModel


class MealsDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentMealsDialogBinding
    private val videoViewModel: ViewModel by viewModels()
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

