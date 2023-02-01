package com.example.restapp.home

import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.example.restapp.MainActivity
import com.example.restapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.*


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val imageAdapter by lazy { MealsImageAdapter() }

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.homeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.homeRecyclerView.adapter = imageAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.meals.observe(viewLifecycleOwner) { meals ->
            imageAdapter.setMeals(meals)
            autoScroll()
//            Log.d("TAG", "onViewCreated: $meals")

        }
    }

    private fun autoScroll() {
        val speedScroll = 10
        val handler = Handler()
        val runnable: java.lang.Runnable = object : java.lang.Runnable {
            var count = 0
            override fun run() {
                if (count == imageAdapter.itemCount) count = 0
                if (count < imageAdapter.itemCount) {
                    binding.homeRecyclerView.smoothScrollToPosition(++count)
                    handler.postDelayed(this, speedScroll.toLong())
                }
            }
        }
        handler.postDelayed(runnable, speedScroll.toLong())
    }

}

//    private val imageAdapter by lazy { HomeViewPagerAdapter() }

//        binding.homeViewPager.adapter = imageAdapter

//        val totalPages = 25
//
//        val pagerPadding = 10
//        binding.homeViewPager.clipToPadding = false
//        binding.homeViewPager.setPadding(pagerPadding, 0, pagerPadding, 0)
//
//        viewModel.meals.observe(viewLifecycleOwner) { meals ->
//            imageAdapter.setMealsImage(meals)
//
//        }
//        CoroutineScope(Dispatchers.Main).launch {
//            while (isActive) {
//                delay(1500)
//                if (binding.homeViewPager.currentItem + 1 > totalPages - 1) {
//                    binding.homeViewPager.currentItem = 0
//                } else {
//                    binding.homeViewPager.currentItem++
//                }
//            }
//        }