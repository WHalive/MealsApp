package com.example.restapp.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restapp.R
import com.example.restapp.databinding.ActivityAuthBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.slots.Slot
import ru.tinkoff.decoro.watchers.MaskFormatWatcher
import java.util.concurrent.TimeUnit

class AuthActivity : AppCompatActivity() {

    private var _binding: ActivityAuthBinding? = null
    private val binding get() = _binding!!


    private var forceResendingToken: PhoneAuthProvider.ForceResendingToken? = null

    private var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null

    private var mVerificationId: String? = null

    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var number: String
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

    private fun sendNumber() {
        number = binding.phoneNumberEditText.text.toString()
        if (number.isNotEmpty()) {
            if (number.length == 9) {
                number = "+998$number"
                val options = PhoneAuthOptions.newBuilder(firebaseAuth)
                    .setPhoneNumber(number)       // Phone number to verify
                    .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                    .setActivity(this)                 // Activity (for callback binding)
                    .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
                    .build()
                PhoneAuthProvider.verifyPhoneNumber(options)
            }
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