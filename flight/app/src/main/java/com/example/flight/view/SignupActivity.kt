package com.example.flight.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flight.R
import com.example.flight.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.signupButton.setOnClickListener {
            val name = binding.nameEditText.text.toString().trim()
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            val confirmPassword = binding.confirmPasswordEditText.text.toString().trim()

            if (validateInput(name, email, password, confirmPassword)) {
                performSignup(name, email, password)
            }
        }
    }

    private fun validateInput(name: String, email: String, password: String, confirmPassword: String): Boolean {
        if (name.isEmpty()) {
            binding.nameEditText.error = getString(R.string.error_name_required)
            return false
        }

        if (email.isEmpty()) {
            binding.emailEditText.error = getString(R.string.error_email_required)
            return false
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailEditText.error = getString(R.string.error_invalid_email)
            return false
        }

        if (password.isEmpty()) {
            binding.passwordEditText.error = getString(R.string.error_password_required)
            return false
        }

        if (password.length < 6) {
            binding.passwordEditText.error = getString(R.string.error_password_length)
            return false
        }

        if (confirmPassword.isEmpty()) {
            binding.confirmPasswordEditText.error = getString(R.string.error_confirm_password_required)
            return false
        }

        if (password != confirmPassword) {
            binding.confirmPasswordEditText.error = getString(R.string.error_passwords_not_match)
            return false
        }

        return true
    }

    private fun performSignup(name: String, email: String, password: String) {
        // TODO: Implement actual signup logic here
        // For now, just show a success message and navigate to login
        Toast.makeText(this, getString(R.string.signup_successful), Toast.LENGTH_SHORT).show()
        
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
} 