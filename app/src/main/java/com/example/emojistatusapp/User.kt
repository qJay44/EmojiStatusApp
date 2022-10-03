package com.example.emojistatusapp

data class User(
    // Should match up exactly like in Firestore
    val displayName: String = "",
    val emojis: String = ""
)
