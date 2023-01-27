package com.example.restapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.restapp.HomeActivity
import com.example.restapp.R
import com.example.restapp.databinding.ActivitySignInBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

class SignInActivity : AppCompatActivity() {

    private var _binding: ActivitySignInBinding? = null
    private val binding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var phoneNumber: String
    private lateinit var forceResendingToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var verificationCode: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        verificationCode = intent.getStringExtra("verificationId").toString()
        forceResendingToken = intent.getParcelableExtra("resendToken")!!
        phoneNumber = intent.getStringExtra("phoneNumber")!!

        firebaseAuth = FirebaseAuth.getInstance()

        binding.receiveCode.setOnClickListener {
            receiveCode()
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.sendAgain.setOnClickListener {
            resendVerificationCode()
        }
    }

    private fun receiveCode() {
        val code = binding.codeEditText.text.toString()
        if (code.isNotEmpty()) {
            if (code.length == 6) {
                val credential: PhoneAuthCredential =
                    PhoneAuthProvider.getCredential(verificationCode, code)
                signInWithPhoneAuthCredential(credential)
            } else {
                Toast.makeText(this, "Enter correct code", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Enter code", Toast.LENGTH_SHORT).show()
        }
    }

    private fun resendVerificationCode() {
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(callbacks)
            .setForceResendingToken(forceResendingToken)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {

            signInWithPhoneAuthCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {

            if (e is FirebaseAuthInvalidCredentialsException) {
                Log.d("TAG", "onVerificationFailed: ${e.toString()}")

            } else if (e is FirebaseTooManyRequestsException) {
                Log.d("TAG", "onVerificationFailed: ${e.toString()}")
            }
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            verificationCode = verificationId
            forceResendingToken = token
        }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this, "Authenticate successfully", Toast.LENGTH_SHORT).show()
                    sendToHome()

                } else {

                    Log.d("TAG", "signInWithPhoneAuthCredential:${task.exception.toString()} ")
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {

                    }
                }
            }
    }

    private fun sendToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
}