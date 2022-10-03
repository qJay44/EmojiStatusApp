package com.example.emojistatusapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class UserAdapter(private val context: Context, options: FirestoreRecyclerOptions<User>)
    : FirestoreRecyclerAdapter<User, UserViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int, model: User) {
        val tvName: TextView = holder.itemView.findViewById(android.R.id.text1)
        val tvEmojis: TextView = holder.itemView.findViewById(android.R.id.text2)
        tvName.text = model.displayName
        tvEmojis.text = model.emojis
    }
}