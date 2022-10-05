package com.example.emojistatusapp

import android.content.Context
import android.text.InputFilter
import android.text.Spanned
import android.util.Log
import android.widget.Toast

class EmojiFilter(private val context: Context) : InputFilter {

    private companion object {
        private const val TAG = "MainActivity"
        private val VALID_CHAR_TYPES = listOf(
            Character.NON_SPACING_MARK, // 6
            Character.DECIMAL_DIGIT_NUMBER, // 9
            Character.LETTER_NUMBER, // 10
            Character.OTHER_NUMBER, // 11
            Character.SPACE_SEPARATOR, // 12
            Character.FORMAT, // 16
            Character.SURROGATE, // 19
            Character.DASH_PUNCTUATION, // 20
            Character.START_PUNCTUATION, // 21
            Character.END_PUNCTUATION, // 22
            Character.CONNECTOR_PUNCTUATION, // 23
            Character.OTHER_PUNCTUATION, // 24
            Character.MATH_SYMBOL, // 25
            Character.CURRENCY_SYMBOL, //26
            Character.MODIFIER_SYMBOL, // 27
            Character.OTHER_SYMBOL // 28
        ).map { it.toInt() }.toSet()
    }

    override fun filter(
        p0: CharSequence?,
        p1: Int,
        p2: Int,
        p3: Spanned?,
        p4: Int,
        p5: Int
    ): CharSequence {

        if (p0 == null || p0.isBlank())
            return ""

        Log.i(TAG, "Added text $p0, it has length of ${p0.length} characters")

        for (inputChar in p0) {
            val type = Character.getType(inputChar)
            Log.i(TAG, "Character type: $type")
            if (!VALID_CHAR_TYPES.contains(type)) {
                Toast.makeText(context, "Only emojis are allowed!", Toast.LENGTH_SHORT).show()
                return ""
            }
        }

        return p0
    }
}
