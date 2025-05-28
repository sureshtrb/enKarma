package com.sureshtrb.enKarma

import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.sureshtrb.enKarma.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private var mProgress: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mProgress = ProgressDialog(this)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.home)
        supportActionBar?.setLogo(R.drawable.karma)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.setTitle("Register / பதிவு செய்க")

        binding.btnRegister.setOnClickListener { doRegister() }
        binding.txtLogin.setOnClickListener {
            val loginIntent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }

    private fun doRegister() {
        binding.editEmail.error = null
        binding.editPassword.error = null

        val email = binding.editEmail.text.toString().trim { it <= ' ' }
        val password = binding.editPassword.text.toString().trim { it <= ' ' }

        if (email.isEmpty() || password.isEmpty()) {
            alertDisplayer(getString(R.string.oops), getString(R.string.fill_all_fields))
            return
        }

        if (!isEmailValid(email)) {
            binding.editEmail.error = getString(R.string.error_invalid_email)
            binding.editEmail.requestFocus()
            return
        }

        if (!isPasswordValid(password)) {
            binding.editPassword.error = getString(R.string.error_invalid_password)
            binding.editPassword.requestFocus()
            return
        }

        mProgress?.setMessage(getString(R.string.register_wait))
        mProgress?.setCancelable(false)
        mProgress?.show()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                mProgress?.dismiss()
                if (task.isSuccessful) {
                    Log.d("RegisterActivity", "createUserWithEmail:success")
                    val user = FirebaseAuth.getInstance().currentUser
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
        AlertDialog.Builder(this@RegisterActivity)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok)) { dialog: DialogInterface?, _: Int -> dialog?.cancel() }
            .show()
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 2 // You might want to adjust your password validation logic
    }
}