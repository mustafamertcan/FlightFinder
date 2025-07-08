package com.example.flight.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flight.R
import com.example.flight.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            if (validateInput(email, password)) {
                performLogin(email, password)
            }
        }

        binding.signupButton.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            binding.emailEditText.error = getString(R.string.error_email_required)
            return false
        }

        if (password.isEmpty()) {
            binding.passwordEditText.error = getString(R.string.error_password_required)
            return false
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailEditText.error = getString(R.string.error_invalid_email)
            return false
        }

        if (password.length < 6) {
            binding.passwordEditText.error = getString(R.string.error_password_length)
            return false
        }

        return true
    }

    private fun performLogin(email: String, password: String) {
        // TODO: Implement actual login logic here
        // For now, just show a success message and navigate to home screen
        Toast.makeText(this, getString(R.string.login_successful), Toast.LENGTH_SHORT).show()
        
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
