package com.example.restapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.restapp.databinding.ActivityHomeBinding
import com.example.restapp.home.HomeFragment
import com.example.restapp.list.ListFragment

class HomeActivity : AppCompatActivity() {
    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment.newInstance()
        val favouriteFragment = FavouriteFragment()
        val searchFragment = SearchFragment()
        val listFragment = ListFragment()
        val infoFragment = InfoFragment()

        val bottomNavigationView = binding.bottomNav
        replaceFragment(homeFragment)

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> replaceFragment(homeFragment)
                R.id.favouriteFragment -> replaceFragment(favouriteFragment)
                R.id.searchFragment -> replaceFragment(searchFragment)
                R.id.listFragment -> replaceFragment(listFragment)
                R.id.infoFragment -> replaceFragment(infoFragment)
            }
            true
        }
        bottomNavigationView.selectedItemId = R.id.homeFragment

    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}