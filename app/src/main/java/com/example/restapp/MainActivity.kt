package com.example.restapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restapp.auth.AuthActivity
import com.example.restapp.app.RestApp
import com.example.restapp.databinding.ActivityMainBinding
import com.example.restapp.welcome.GreetingViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupViewPager2()
        binding.greetingNext.setOnClickListener {
            onNextClick()


        }
    }

    override fun onStart() {
        super.onStart()
        if (RestApp.INSTANCE.prefs.getIsClicked) {
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }

    }

    private fun setupViewPager2() {
        val image: MutableList<Int> = ArrayList()
        image.add(R.drawable.greeting1)
        image.add(R.drawable.greeting2)
        image.add(R.drawable.greeting3)

        val text: MutableList<String> = ArrayList()
        text.add("It is free!")
        text.add("Enjoy  with Resttab!")
        text.add("Best meals all over the world!")

        val description: MutableList<String> = ArrayList()
        description.add("Best meals all over the world!")
        description.add("See and prepare, repeat and be one of us")
        description.add("Welcome")

        binding.viewPager2.adapter = GreetingViewPagerAdapter(this, image, text, description)
        binding.dotIndicator.setViewPager2(binding.viewPager2)
    }

//    private fun next() {
//        binding.greetingNext.setOnClickListener {
//            val myPosition = binding.viewPager2.currentItem
//            when (myPosition) {
//                0 -> binding.viewPager2.currentItem = 1
//                1 -> binding.viewPager2.currentItem = 2
//                2 -> binding.viewPager2.currentItem
//            }
//            if (myPosition == 2) {
//                val intent = Intent(this, HomeActivity::class.java)
//                startActivity(intent)
//            }
//        }
//    }

    private fun onNextClick() {
        RestApp.INSTANCE.prefs.saveIsNextClicked(true)
        if (binding.viewPager2.currentItem == 2) {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        } else {
            binding.viewPager2.currentItem = binding.viewPager2.currentItem + 1
        }
    }

}