package com.example.restapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.example.restapp.R
import com.example.restapp.databinding.ActivityAuthBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.slots.Slot
import ru.tinkoff.decoro.watchers.MaskFormatWatcher
import java.util.concurrent.TimeUnit

class AuthActivity : AppCompatActivity() {

    private var _binding: ActivityAuthBinding? = null
    private val binding get() = _binding!!
    private var forceResendingToken: PhoneAuthProvider.ForceResendingToken? = null

    //    private var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null
    private lateinit var verificationCode: String
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var phoneNumber: String
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendCode.setOnClickListener {
            sendNumber()
        }
        firebaseAuth = FirebaseAuth.getInstance()

        val mask = MaskImpl.createTerminated(UZ_PHONE_NUMBER.toTypedArray())
        mask.isShowingEmptySlots = true
        mask.placeholder = '#'
        val watcher = MaskFormatWatcher(mask)
        watcher.installOn(binding.phoneNumberEditText)

    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            startActivity(Intent(this, AuthActivity::class.java))
        }
    }

    private fun sendNumber() {
        phoneNumber = binding.phoneNumberEditText.text.toString()
        if (phoneNumber.isNotEmpty()) {
            if (phoneNumber.length == 9) {
                phoneNumber = "+998$phoneNumber"

                progressBar.visibility = View.VISIBLE

                val options = PhoneAuthOptions.newBuilder(firebaseAuth)
                    .setPhoneNumber(phoneNumber)       // Phone number to verify
                    .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                    .setActivity(this)                 // Activity (for callback binding)
                    .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
                    .build()
                PhoneAuthProvider.verifyPhoneNumber(options)
            }
        }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                } else {

                    if (task.exception is FirebaseAuthInvalidCredentialsException) {

                    }

                }
            }
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
            progressBar.visibility = View.INVISIBLE
//            storedVerificationId = verificationId
//            resendToken = token
        }
    }
}

private val UZ_PHONE_NUMBER = listOf(
    PredefinedSlots.hardcodedSlot('+'),
    PredefinedSlots.hardcodedSlot('9'),
    PredefinedSlots.hardcodedSlot('9'),
    PredefinedSlots.hardcodedSlot('8'),
    PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
//    PredefinedSlots.hardcodedSlot('(').withTags(Slot.TAG_DECORATION),
    PredefinedSlots.digit(),
    PredefinedSlots.digit(),
//    PredefinedSlots.hardcodedSlot(')').withTags(Slot.TAG_DECORATION),
    PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
    PredefinedSlots.digit(),
    PredefinedSlots.digit(),
    PredefinedSlots.digit(),
    PredefinedSlots.hardcodedSlot('-').withTags(Slot.TAG_DECORATION),
    PredefinedSlots.digit(),
    PredefinedSlots.digit(),
    PredefinedSlots.hardcodedSlot('-').withTags(Slot.TAG_DECORATION),
    PredefinedSlots.digit(),
    PredefinedSlots.digit(),
)