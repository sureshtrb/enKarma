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
import com.karma.sureshtrb.enKarma.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private var binding: ActivityLoginBinding? = null
    private var mProgress: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        mProgress = ProgressDialog(this)

        // ... (Toolbar setup) ...

        binding!!.loginButton.setOnClickListener { doLogin() }
        binding!!.resetPasswordButton.setOnClickListener {
            val resetPasswordIntent = Intent(applicationContext, ForgotPasswordActivity::class.java)
            startActivity(resetPasswordIntent)
        }
        binding!!.textViewSignup.setOnClickListener {
            val registerIntent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(registerIntent)
        }
        binding!!.skipButton.setOnClickListener {
            val skipIntent = Intent(applicationContext, SkipSelectionActivity::class.java)
            startActivity(skipIntent)
        }
    }

    private fun doLogin() {
        binding!!.editTextEmail.error = null
        binding!!.editTextPassword.error = null

        val email = binding!!.editTextEmail.text.toString()
        val password = binding!!.editTextPassword.text.toString()

        if (email.isEmpty()) {
            binding!!.editTextEmail.error = getString(R.string.error_field_required)
            binding!!.editTextEmail.requestFocus()
            return
        }

        if (!isEmailValid(email)) {
            binding!!.editTextEmail.error = getString(R.string.error_invalid_email)
            binding!!.editTextEmail.requestFocus()
            return
        }

        if (password.isEmpty()) {
            binding!!.editTextPassword.error = getString(R.string.error_field_required)
            binding!!.editTextPassword.requestFocus()
            return
        }

        if (!isPasswordValid(password)) {
            binding!!.editTextPassword.error = getString(R.string.error_invalid_password)
            binding!!.editTextPassword.requestFocus()
            return
        }

        mProgress?.setMessage(getString(R.string.login_wait))
        mProgress?.setCancelable(false)
        mProgress?.show()

        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                mProgress?.dismiss()
                if (task.isSuccessful) {
                    Log.d("LoginActivity", "signInWithEmail:success")
                    val user = auth.currentUser
                    val intent = Intent(applicationContext, SelectionActivity::class.java)
                    intent.putExtra("Username", email) // Or user.displayName if available
                    startActivity(intent)
                    finish()
                } else {
                    Log.w("LoginActivity", "signInWithEmail:failure", task.exception)
                    alertDisplayer("Login failed", "Please check your credentials.")
                }
            }
    }

    private fun alertDisplayer(message: String?) {
        AlertDialog.Builder(this@LoginActivity)
            .setTitle("Login failed")
            .setMessage(message)
            .setPositiveButton("OK") { dialog: DialogInterface?, which: Int -> dialog?.cancel() }
            .show()
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5 // Example: Password must be at least 6 characters long
    }
}