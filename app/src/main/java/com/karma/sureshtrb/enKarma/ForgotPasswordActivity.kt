package com.karma.sureshtrb.enKarma

import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.karma.sureshtrb.enKarma.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding
    private var mProgress: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mProgress = ProgressDialog(this)

        // Optional: configure action bar if present
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.home)
        supportActionBar?.setLogo(R.drawable.karma)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.title = "சங்கேதமொழி சீர்செய்ய.." // keep your title

        binding.bForgotPassword.setOnClickListener { resetPassword() }
    }

    private fun alertDisplayer(title: String, message: String) {
        AlertDialog.Builder(this@ForgotPasswordActivity)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog: DialogInterface?, _ -> dialog?.cancel() }
            .create()
            .show()
    }

    private fun resetPassword() {
        val email = binding.editEmail.text.toString().trim()

        if (email.isEmpty()) {
            alertDisplayer("Error", "Please enter your email address.")
            return
        }

        mProgress?.setMessage("Please wait...")
        mProgress?.show()

        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                mProgress?.dismiss()
                if (task.isSuccessful) {
                    Log.d("ForgotPassword", "Email sent.")
                    alertDisplayer("Password Reset Email Sent!", "Check your email to change your password.")
                } else {
                    Log.w("ForgotPassword", "Email not sent.", task.exception)
                    val msg = task.exception?.message ?: "Unknown error"
                    alertDisplayer("Password Reset Failed", "Could not send reset email: $msg")
                }
            }
    }
}
