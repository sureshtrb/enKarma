package com.karma.sureshtrb.enKarma

import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.karma.sureshtrb.enKarma.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private var mProgress: ProgressDialog? = null

    @Suppress("DEPRECATION") // ProgressDialog is deprecated; consider replacing with a custom loading dialog later
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize progress dialog
        mProgress = ProgressDialog(this)

        // Setup ActionBar
        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.home)
            setLogo(R.drawable.karma)
            setDisplayUseLogoEnabled(true)
            title = "Register / பதிவு செய்க"
        }

        // Register button click
        binding.btnRegister.setOnClickListener {
            doRegister()
        }

        // Navigate to LoginActivity when clicking "Already have an account?" text
        binding.txtLogin.setOnClickListener {
            val loginIntent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }

    private fun doRegister() {
        // Clear previous errors
        binding.editEmail.error = null
        binding.editPassword.error = null

        val email = binding.editEmail.text.toString().trim()
        val password = binding.editPassword.text.toString().trim()

        // Input validation
        when {
            email.isEmpty() || password.isEmpty() -> {
                alertDisplayer(getString(R.string.oops), getString(R.string.fill_all_fields))
                return
            }
            !isEmailValid(email) -> {
                binding.editEmail.error = getString(R.string.error_invalid_email)
                binding.editEmail.requestFocus()
                return
            }
            !isPasswordValid(password) -> {
                binding.editPassword.error = getString(R.string.error_invalid_password)
                binding.editPassword.requestFocus()
                return
            }
        }

        // Show loading
        mProgress?.apply {
            setMessage(getString(R.string.register_wait))
            setCancelable(false)
            show()
        }

        // Firebase Authentication: Register user
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                mProgress?.dismiss()
                if (task.isSuccessful) {
                    Log.d("RegisterActivity", "createUserWithEmail:success")
                    alertDisplayer(
                        getString(R.string.title_register_alert),
                        getString(R.string.message_register_alert_login_success)
                    )
                } else {
                    Log.w("RegisterActivity", "createUserWithEmail:failure", task.exception)
                    alertDisplayer(
                        getString(R.string.error_register_title),
                        task.exception?.message ?: getString(R.string.error_register_generic)
                    )
                }
            }
    }

    private fun alertDisplayer(title: String?, message: String?) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok)) { dialog: DialogInterface?, _ ->
                dialog?.cancel()
            }
            .show()
    }

    private fun isEmailValid(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isPasswordValid(password: String): Boolean =
        password.length > 2 // Adjust password policy as needed
}
