package com.sureshtrb.enKarma

import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth

class User(context: Context) {
    var context: Context?

    fun removeUser() {
        sharedPreferences.edit().clear().apply()
        // Sign out the user from Firebase Authentication (if applicable)
        FirebaseAuth.getInstance().signOut()
    }

    fun getUsername(): String {
        // Retrieve username from Firebase Authentication or Firestore (if applicable)
        val username = FirebaseAuth.getInstance().currentUser?.displayName ?: ""
        return username
    }

    fun setUsername(username: String?) {
        // Update username in Firebase Authentication or Firestore (if applicable)
        // ...
        sharedPreferences.edit().putString("userdata", username).apply()
    }

    private var Username: String? = null

    private val sharedPreferences: SharedPreferences

    init {
        this.context = context
        sharedPreferences = context.getSharedPreferences("userinfo", Context.MODE_PRIVATE)
    }
}
