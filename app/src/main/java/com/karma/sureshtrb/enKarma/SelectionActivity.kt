package com.karma.sureshtrb.enKarma

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.karma.sureshtrb.enKarma.databinding.ActivitySelectionBinding

class SelectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectionBinding
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressBar = findViewById(R.id.progressBar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            subtitle = "Select / தேர்வு செய்க..."
            setDisplayShowHomeEnabled(true)
            setLogo(R.drawable.karma)
            setDisplayUseLogoEnabled(true)
        }

        binding.sandyaButton.setOnClickListener {
            val intentSandya = Intent(this, SandhiData::class.java)
            startActivity(intentSandya)
        }

        binding.pariButton.setOnClickListener {
            val intentPari = Intent(this, PariActivity::class.java)
            startActivity(intentPari)
        }

        binding.tharpanamButton.setOnClickListener {
            val intentTharpanam = Intent(this, TharoPanchangamActivity::class.java)
            startActivity(intentTharpanam)
        }

        binding.buttonLogout.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            FirebaseAuth.getInstance().signOut()

            val intentLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentLogin)
            finish()

            progressBar.visibility = View.GONE
            alertDisplayer(title = "Signing out...")
        }
    }

    private fun alertDisplayer(title: String) {
        val message = """
            Thanks!  
            Please continue with NITHYA KARMA daily without fail  
            
            நன்றி!  
            தினமும் தவறாது நித்ய கர்மாவை அனுஷ்டிக்கவும்
        """.trimIndent()

        val builder = AlertDialog.Builder(this@SelectionActivity)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.cancel()
            }

        builder.create().show()
    }
}
