package com.karma.sureshtrb.enKarma

import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth

class User(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("userinfo", Context.MODE_PRIVATE)

    fun removeUser() {
        sharedPreferences.edit().clear().apply()
        FirebaseAuth.getInstance().signOut() // Sign out from Firebase
    }

    fun getUsername(): String {
        return FirebaseAuth.getInstance().currentUser?.displayName ?: ""
    }

    fun setUsername(username: String?) {
        sharedPreferences.edit().putString("userdata", username).apply()
    }
}
