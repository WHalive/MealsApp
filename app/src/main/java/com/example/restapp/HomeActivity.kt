package com.example.restapp

import android.app.ProgressDialog.show
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.restapp.databinding.ActivityHomeBinding
import com.example.restapp.home.HomeFragment
import com.example.restapp.word.WordFragment
import com.example.restapp.list.ListFragment
import com.example.restapp.meals.MealsFragment
import com.example.restapp.networkWarning.NetworkConnection
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inflateLayout =findViewById<View>(R.id.networkError)
        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this){
            if(it){
             inflateLayout.visibility = View.GONE

//                Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
            }else {
                inflateLayout.visibility = View.VISIBLE
//                Toast.makeText(this, "Not Connected", Toast.LENGTH_SHORT).show()
            Snackbar.make(requireViewById(R.id.networkError), "Please, Check Internet Connection!", Snackbar.LENGTH_SHORT)
                .show()
            }
        }
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
        transaction.addToBackStack("")
        transaction.commit()
    }



}

