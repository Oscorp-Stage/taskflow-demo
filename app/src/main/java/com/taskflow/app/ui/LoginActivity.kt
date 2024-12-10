package com.taskflow.app.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.taskflow.app.data.DummyUsers
import com.taskflow.app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
        setupTextWatchers()
        setupClickListeners()
        
        // Check if there's a registration success message
        intent.getStringExtra("registration_email")?.let { email ->
            binding.etEmail.setText(email)
            binding.tilEmail.helperText = "Registration successful! Please login."
        }
    }
    
    private fun setupTextWatchers() {
        binding.etEmail.addTextChangedListener {
            binding.tilEmail.error = null
            binding.tilEmail.helperText = null
        }
        
        binding.etPassword.addTextChangedListener {
            binding.tilPassword.error = null
        }
    }
    
    private fun setupClickListeners() {
        binding.btnLogin.setOnClickListener {
            if (validateInputs()) {
                showLoading(true)
                performLogin()
            }
        }
        
        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
        
        binding.tvForgotPassword.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Password reset link sent to your email", Toast.LENGTH_SHORT).show()
            } else {
                binding.tilEmail.error = "Please enter a valid email to reset password"
            }
        }
    }

    private fun validateInputs(): Boolean {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        
        if (email.isEmpty()) {
            binding.tilEmail.error = "Email is required"
            return false
        }
        
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Please enter a valid email"
            return false
        }
        
        if (password.isEmpty()) {
            binding.tilPassword.error = "Password is required"
            return false
        }
        
        return true
    }
    
    private fun performLogin() {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        
        Log.d("LoginActivity", "Login attempt - Email: $email")
        
        // Simulate network delay
        binding.root.postDelayed({
            if (DummyUsers.validateUser(email, password)) {
                if (binding.cbRememberMe.isChecked) {
                    // TODO: Save credentials securely
                }
                
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java).apply {
                    putExtra("email", email)
                }
                startActivity(intent)
                finish()
            } else {
                showLoading(false)
                // Check if the email exists to provide more specific error message
                if (DummyUsers.isEmailTaken(email)) {
                    binding.tilPassword.error = "Incorrect password"
                } else {
                    binding.tilEmail.error = "Email not registered"
                }
            }
        }, 1500) // Simulate 1.5s delay
    }
    
    private fun showLoading(show: Boolean) {
        binding.btnLogin.isEnabled = !show
        binding.progressBar.visibility = if (show) View.VISIBLE else View.GONE
        binding.tvLoginText.visibility = if (show) View.GONE else View.VISIBLE
    }
}