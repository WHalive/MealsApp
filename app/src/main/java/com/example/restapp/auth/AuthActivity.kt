package com.example.restapp.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restapp.R
import com.example.restapp.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private var _binding: ActivityAuthBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, SignInFragment.newInstance())
            .commit()

    }
}