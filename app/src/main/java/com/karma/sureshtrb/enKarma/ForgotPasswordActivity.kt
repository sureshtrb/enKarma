package com.karma.sureshtrb.enKarma

import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.util.Patterns
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

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.home)
        supportActionBar?.setLogo(R.drawable.karma)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.setTitle("சங்கேதமொழி சீர்செய்ய..")

        binding.bForgotPassword.setOnClickListener { resetPassword() }
    }

    private fun alertDisplayer(title: String?, message: String?) {
        AlertDialog.Builder(this@ForgotPasswordActivity)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog: DialogInterface?, _: Int -> dialog?.cancel() }
            .create()
            .show()
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun resetPassword() {
        val email = binding.editEmail.text.toString().trim { it <= ' ' }

        // Validate email before sending reset request
        if (email.isEmpty()) {
            binding.editEmail.error = getString(R.string.error_field_required)
            binding.editEmail.requestFocus()
            return
        }

        if (!isEmailValid(email)) {
            binding.editEmail.error = getString(R.string.error_invalid_email)
            binding.editEmail.requestFocus()
            return
        }

        mProgress?.setMessage("Please wait...")
        mProgress?.setCancelable(false)
        mProgress?.show()

        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                mProgress?.dismiss()
                if (task.isSuccessful) {
                    Log.d("ForgotPassword", "Email sent.")
                    val title = "Password Reset Email Sent!"
                    val message = "Check Your Email To Change Your Password"
                    alertDisplayer(title, message)
                } else {
                    Log.w("ForgotPassword", "Email not sent.", task.exception)
                    val title = "Password Reset Failed"
                    val message = task.exception?.message ?: "Unable to send reset email. Please check your email address."
                    alertDisplayer(title, message)
                }
            }
    }
}
