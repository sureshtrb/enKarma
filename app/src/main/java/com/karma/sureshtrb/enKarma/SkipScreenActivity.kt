package com.karma.sureshtrb.enKarma

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.karma.sureshtrb.enKarma.databinding.ActivitySkipScreenBinding

class SkipScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySkipScreenBinding

    @Suppress("DEPRECATION") // ProgressDialog is deprecated — consider using a custom ProgressBar/dialog in future
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkipScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup action bar safely
        supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.home)
            setDisplayHomeAsUpEnabled(true)
            subtitle = "பதிவு செய்க..."
            setDisplayShowHomeEnabled(true)
            setLogo(R.drawable.karma)
            setDisplayUseLogoEnabled(true)
        }

        // Marquee-like behavior for the TextView (keeps it scrolling)
        binding.skipTextView.apply {
            isSingleLine = true
            isSelected = true
            text = "You need to Register or Login to view the Tharpanam. Please Login or Register"
        }

        // Use binding to access the button (no findViewById)
        binding.RegisterOrLogin.setOnClickListener {
            // Properly create the ProgressDialog instance
            val dlg = ProgressDialog(this@SkipScreenActivity).apply {
                setTitle("Please, wait a moment.")
                setMessage("Will be taken to Login....")
                setCancelable(false)
                show()
            }

            // Sign out from Firebase (if user was signed in)
            FirebaseAuth.getInstance().signOut()

            // Navigate to LoginActivity
            val intentLogin = Intent(this@SkipScreenActivity, LoginActivity::class.java)
            startActivity(intentLogin)

            // Optional: finish this activity so user cannot return to it with back-button
            // finish()

            // Dismiss the progress dialog
            dlg.dismiss()

            // Show a friendly alert after redirecting (kept your original message)
            alertDisplayer(
                title = "Login....",
                message = "Thanks! \nPlease continue with NITHYA KARMA daily without fail\n\nநன்றி! \nதினமும் தவறாது நித்ய கர்மாவை அனுஷ்டிக்கவும்"
            )
        }
    }

    private fun alertDisplayer(title: String, message: String) {
        AlertDialog.Builder(this@SkipScreenActivity)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ -> dialog.cancel() }
            .create()
            .show()
    }
}
