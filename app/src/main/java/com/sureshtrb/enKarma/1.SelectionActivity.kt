package com.sureshtrb.enKarma

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.*
import com.sureshtrb.enKarma.databinding.ActivitySelectionBinding

class SelectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectionBinding     private lateinit var progressBar: ProgressBar      override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) binding = ActivitySelectionBinding . inflate (layoutInflater) setContentView (binding.root) progressBar = findViewById (R.id.progressBar) supportActionBar !!. setDisplayHomeAsUpEnabled (false) supportActionBar !!. subtitle = "Select / தேர்வு செய்க..."         supportActionBar!!.setDisplayShowHomeEnabled(true)         supportActionBar!!.setLogo(R.drawable.karma)         supportActionBar!!.setDisplayUseLogoEnabled(true)          binding.SandyaButton.setOnClickListener {
            Intent(this, SandhiData::class.java) startActivity (intentSandya)
        } binding . pariButton . setOnClickListener {
            Intent(this, PariActivity::class.java) startActivity (intentPari)
        } binding . tharpanamButton . setOnClickListener {
            Intent(this, TharoPanchangamActivity::class.java) startActivity (intentTharpanam)
        } binding . buttonLogout . setOnClickListener {
            progressBar.visibility = View.VISIBLE FirebaseAuth . getInstance ().signOut()
            Intent(
                this,
                LoginActivity::class.java
            ) startActivity (intentLogin) finish () progressBar . visibility = View . GONE              // Swapped the arguments to alertDisplayer()             alertDisplayer(title = "                     Signing out....")         }     }      private fun alertDisplayer(title: String) {         val message = "Thanks!\nPlease continue with NITHYA KARMA daily without fail\n" +                 "\nநன்றி! \nதினமும் தவறாது நித்ய கர்மாவை அனுஷ்டிக்கவும்"         val builder = AlertDialog.Builder(this@SelectionActivity)             .setTitle(title)             .setMessage(message)             .setPositiveButton("OK") { dialog, _ ->                 dialog.cancel()             }         val ok = builder.create()         ok.show()     } }