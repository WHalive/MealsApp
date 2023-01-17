package com.example.restapp.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.restapp.databinding.FragmentSignInBinding
import ru.tinkoff.decoro.Mask
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.slots.Slot
import ru.tinkoff.decoro.watchers.FormatWatcher
import ru.tinkoff.decoro.watchers.MaskFormatWatcher


class SignInFragment : Fragment() {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)

        val mask = MaskImpl.createTerminated(UZ_PHONE_NUMBER.toTypedArray())
        mask.isShowingEmptySlots = true
        mask.placeholder = '#'
        val watcher = MaskFormatWatcher(mask)
        watcher.installOn(binding.phoneNumberEditText)

        return binding.root
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