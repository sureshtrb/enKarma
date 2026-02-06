package com.karma.sureshtrb.enKarma

//import androidx.privacysandbox.tools.core.generator.build
import android.app.Application
import android.content.Context
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.database.ktx.database
import com.google.firebase.installations.FirebaseInstallations
//import com.google.firebase.ktx.Firebase

class App : Application() {

    companion object {
        lateinit var fid: String
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        // Initialize Firebase
        FirebaseApp.initializeApp(this)
       // Firebase.database.setPersistenceEnabled(true)
        // Enable offline persistence
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
/*
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server("https://parseapi.back4app.com/")
                .build()
        )*/

        FirebaseInstallations.getInstance().id.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                fid = task.result
                // Store the FID in SharedPreferences if needed
            } else {
                // Handle error, e.g., log the error or use a default FID
                Log.e("App", "Error getting FID: " + (task.exception?.message ?: "Unknown error"))
                fid = "default_fid" // Or any other default value
            }
        }
    }
}