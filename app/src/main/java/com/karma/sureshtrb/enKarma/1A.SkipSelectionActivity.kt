package com.sureshtrb.enKarma

//import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.sureshtrb.enKarma.databinding.ActivitySkipSelectionBinding

class SkipSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySkipSelectionBinding
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkipSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize progressBar
        progressBar = findViewById(R.id.progressBar) //

        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        supportActionBar!!.subtitle = "Select / தேர்வு செய்க..."
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.karma)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        binding.SandyaButton.setOnClickListener {
            val intentSandya = Intent(this, SandhiData::class.java)
            startActivity(intentSandya)
        }
        binding.pariButton.setOnClickListener {
            val intentPari = Intent(this, PariActivity::class.java)
            startActivity(intentPari)
        }
        binding.tharpanamButton.setOnClickListener {
            val intentSkip = Intent(this, SkipScreenActivity::class.java)
            startActivity(intentSkip)
        }
        binding.about.setOnClickListener {
            val intentAbout = Intent(this, AboutActivity::class.java)
            startActivity(intentAbout)
        }

        binding.buttonLogout.setOnClickListener {
            progressBar.visibility = View.VISIBLE // Show progressBar

            FirebaseAuth.getInstance().signOut()

            // Firebase Authentication sign-out
            FirebaseAuth.getInstance().signOut()

            // Handle navigation after logout (e.g., go to LoginActivity)
            val intentLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentLogin)
            finish() // Optional: Finish the current activity
            progressBar.visibility = View.GONE // Hide progressBar

            alertDisplayer(
    title = "                     Signing out....",
    message = "Thanks!\nPlease continue with NITHYA KARMA daily without fail\n" +
            "\nநன்றி! \nதினமும் தவறாது நித்ய கர்மாவை அனுஷ்டிக்கவும்"
)
        }
    }

    private fun alertDisplayer(title: String, message: String) {
        val builder = AlertDialog.Builder(this@SkipSelectionActivity)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.cancel()
            }
        val ok = builder.create()
        ok.show()
    }
}