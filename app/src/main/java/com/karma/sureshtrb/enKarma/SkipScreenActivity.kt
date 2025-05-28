package com.sureshtrb.enKarma

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.sureshtrb.enKarma.databinding.ActivitySkipScreenBinding

class SkipScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySkipScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkipScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.home)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.subtitle = "பதிவு செய்க..."
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.karma)
        supportActionBar?.setDisplayUseLogoEnabled(true)

        binding.skipTextView.isSingleLine = true
        binding.skipTextView.isSelected = true
        binding.skipTextView.text = "You need to Register or Login to view the Tharpanam. Please Login or Register"

        val logoutButton = findViewById<Button>(R.id.RegisterOrLogin)
        logoutButton.setOnClickListener {
            val dlg = ProgressDialog(this@SkipScreenActivity)
            dlg.setTitle("Please, wait a moment.")
            dlg.setMessage("Will be taken to Login....")
            dlg.show()

            // Firebase Authentication sign-out
            FirebaseAuth.getInstance().signOut()

            // Handle navigation after logout (e.g., go to LoginActivity)
            val intentLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentLogin)
            // finish() // Optional: Finish the current activity if needed
            dlg.dismiss()

            alertDisplayer(
                "                     Login....",
                "Thanks! \nPlease continue with NITHYA KARMA daily without fail\n" +
                        "\nநன்றி! \nதினமும் தவறாது நித்ய கர்மாவை அனுஷ்டிக்கவும்"
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