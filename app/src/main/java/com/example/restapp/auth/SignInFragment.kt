package com.example.restapp.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.restapp.databinding.FragmentSignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.ktx.Firebase
import ru.tinkoff.decoro.Mask
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.slots.Slot
import ru.tinkoff.decoro.watchers.FormatWatcher
import ru.tinkoff.decoro.watchers.MaskFormatWatcher
import java.util.concurrent.TimeUnit


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