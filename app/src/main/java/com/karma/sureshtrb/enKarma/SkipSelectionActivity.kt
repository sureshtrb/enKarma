package com.karma.sureshtrb.enKarma

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.karma.sureshtrb.enKarma.databinding.ActivitySelectionBinding
import com.parse.ParseUser

class SkipSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            subtitle = "Select / தேர்வு செய்க..."
            setDisplayShowHomeEnabled(true)
            setLogo(R.drawable.karma)
            setDisplayUseLogoEnabled(true)
        }

        binding.sandyaButton.setOnClickListener {
            startActivity(Intent(this, SandhiData::class.java))
        }
        binding.pariButton.setOnClickListener {
            startActivity(Intent(this, PariActivity::class.java))
        }
        binding.tharpanamButton.setOnClickListener {
            startActivity(Intent(this, SkipScreenActivity::class.java))
        }
        binding.about.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        binding.buttonLogout.setOnClickListener {
            val dlg = ProgressDialog(this)
            dlg.setTitle("Please, wait a moment.")
            dlg.setMessage("Signing Out...")
            dlg.show()

            ParseUser.logOut()
            alertDisplayer(
                "Signing out...",
                "Thanks! \nPlease continue with NITHYA KARMA daily without fail\n\nநன்றி! \nதினமும் தவறாது நித்ய கர்மாவை அனுஷ்டிக்கவும்"
            )
        }
    }

    private fun alertDisplayer(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.cancel()
            }
        builder.create().show()
    }
}
