package com.example.restapp.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.restapp.R
import com.example.restapp.databinding.FragmentGridBinding

class GridFragment : Fragment() {

    private lateinit var binding: FragmentGridBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGridBinding.inflate(inflater, container, false)
        return binding.root
    }

}