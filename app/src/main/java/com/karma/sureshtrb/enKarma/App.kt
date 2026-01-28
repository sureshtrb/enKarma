package com.karma.sureshtrb.enKarma

import android.app.Application
import android.content.Context
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.settings
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.ktx.Firebase

class App : Application() {

    companion object {
        lateinit var fid: String
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        if (isMainProcess()) {
            // Initialize Firebase only in the main process
            FirebaseApp.initializeApp(this)

            // Enable Realtime Database offline persistence safely
            Firebase.database.setPersistenceEnabled(true)

            // Optionally enable Firestore offline support
            Firebase.firestore.firestoreSettings = settings { isPersistenceEnabled = true }

            // Retrieve Firebase Installation ID
            FirebaseInstallations.getInstance().id
                .addOnSuccessListener { installationId ->
                    fid = installationId ?: "unknown_fid"
                    Log.d("App", "Firebase Installation ID: $fid")
                }
                .addOnFailureListener { e ->
                    Log.e("App", "Error getting FID", e)
                    fid = "default_fid"
                }
        }
    }

    private fun isMainProcess(): Boolean =
        Application.getProcessName() == packageName
}
