package com.example.restapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapp.databinding.FragmentHomeBinding
import com.example.restapp.viewModel.ViewModel


class HomeFragment : Fragment(), MealsImageAdapter.RecyclerViewEvent {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: ViewModel by viewModels()
    private val imageAdapter by lazy { MealsImageAdapter(this) }
    private val categoryAdapter by lazy { HomeCategoryRecyclerViewAdapter() }

//    val api_key =  "AIzaSyCLNsFm2XHl_jJ5mZDwySEM-gyMl36XAcQ"
//    it is for youtube videos

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
        binding.homeCategoryRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.homeCategoryRecyclerView.adapter = categoryAdapter

        return binding.root
    }

    override fun onItemClick(position: Int) {
        MealsDialogFragment().show(childFragmentManager, "dialog")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.meals.observe(viewLifecycleOwner) { meals ->
            imageAdapter.setMeals(meals)
            viewModel.mealsCategory.observe(viewLifecycleOwner) { categories ->
                categoryAdapter.setCategory(categories)

            }
//            autoScroll()
//            Log.d("TAG", "onViewCreated: $meals")

        }
    }

//    private fun autoScroll() {
//        val speedScroll = 10
//        val handler = Handler()
//        val runnable: java.lang.Runnable = object : java.lang.Runnable {
//            var count = 0
//            override fun run() {
//                if (count == imageAdapter.itemCount) count = 0
//                if (count < imageAdapter.itemCount) {
//                    binding.homeRecyclerView.smoothScrollToPosition(++count)
//                    handler.postDelayed(this, speedScroll.toLong())
//                }
//            }
//        }
//        handler.postDelayed(runnable, speedScroll.toLong())
//    }

}


//binding.youtubePlayerView.initialize(api_key, object : YouTubePlayer.OnInitializedListener{
//            override fun onInitializationSuccess(
//                provider: YouTubePlayer.Provider?,
//                player: YouTubePlayer?,
//                p2: Boolean
//            ) {
//                player?.loadVideo("VVnZd8A84z4")
//                player?.play()
//            }
//            override fun onInitializationFailure(
//                p0: YouTubePlayer.Provider?,
//                p1: YouTubeInitializationResult?
//            ) {
//                Toast.makeText(this@HomeFragment.context , "Video player Failed" , Toast.LENGTH_SHORT).show()
//            }
//        })


//    private val imageAdapter by lazy { HomeViewPagerAdapter() }
//        binding.homeViewPager.adapter = imageAdapter
//        val totalPages = 25
//        val pagerPadding = 10
//        binding.homeViewPager.clipToPadding = false
//        binding.homeViewPager.setPadding(pagerPadding, 0, pagerPadding, 0)
//        viewModel.meals.observe(viewLifecycleOwner) { meals ->
//            imageAdapter.setMealsImage(meals)
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