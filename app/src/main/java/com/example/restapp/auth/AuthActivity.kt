package com.example.restapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.example.restapp.HomeActivity
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
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var phoneNumber: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.sendCode.setOnClickListener {
            sendNumber()
        }

        val mask = MaskImpl.createTerminated(UZ_PHONE_NUMBER.toTypedArray())
        mask.isShowingEmptySlots = true
        mask.placeholder = '#'
        val watcher = MaskFormatWatcher(mask)
        watcher.installOn(binding.phoneNumberEditText)

    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }

    private fun sendNumber() {
        phoneNumber = binding.phoneNumberEditText.text?.trim().toString()
        if (phoneNumber.isNotEmpty()) {
            if (phoneNumber.length == 17) {
                phoneNumber = phoneNumber
                val options = PhoneAuthOptions.newBuilder(firebaseAuth)
                    .setPhoneNumber(phoneNumber)       // Phone number to verify
                    .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                    .setActivity(this)                 // Activity (for callback binding)
                    .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
                    .build()
                PhoneAuthProvider.verifyPhoneNumber(options)
                Log.d("ASD", "Auth started")

            } else {
                Toast.makeText(this, "Please Enter correct number", Toast.LENGTH_SHORT).show()
                Log.d("ASD", "sendNumber: $phoneNumber")
            }
        } else {
            Toast.makeText(this, "Please Enter number", Toast.LENGTH_SHORT).show()
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

            val intent = Intent(this@AuthActivity, SignInActivity::class.java)
            intent.putExtra("verificationId", verificationId)
            intent.putExtra("resendToken", token)
            intent.putExtra("phoneNumber", phoneNumber)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

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