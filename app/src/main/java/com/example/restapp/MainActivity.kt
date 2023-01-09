package com.example.restapp

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.restapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //    private var titleList = mutableListOf<String>()
//    private var image = Int
//    private var imageList = mutableListOf<Int>()
//    private var descriptionList = mutableListOf<String>()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    //    private val greetingViewPagerAdapter by lazy { GreetingViewPagerAdapter(this, image, ) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewPager2()
        next()

    }

    private fun setupViewPager2() {

        val image: MutableList<Int> = ArrayList()
        image.add(R.drawable.greeting1)
        image.add(R.drawable.greeting2)
        image.add(R.drawable.greeting3)

        val text: MutableList<String> = ArrayList()
        text.add("Абсолютно бесплатно!")
        text.add("Экономьте вместе с Resttab!")
        text.add("Более 400 ресторанов в одном приложении!")

        val description: MutableList<String> = ArrayList()
        description.add("Используйте все возможности Resttab абсолютно бесплатно!")
        description.add("Бронируйте столик в ресторанах с выгодными предложениями от наших партнеров")
        description.add("")

        binding.viewPager2.adapter = GreetingViewPagerAdapter(this, image, text, description)
        binding.dotIndicator.setViewPager2(binding.viewPager2)
    }

    private fun next() {
        binding.greetingNext.setOnClickListener {
            setupViewPager2()
            binding.dotIndicator.setViewPager2(binding.viewPager2)
        }
    }
}