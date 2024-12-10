package com.taskflow.app.ui

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.taskflow.app.data.DummyUsers
import com.taskflow.app.data.User
import com.taskflow.app.databinding.ActivityRegistrionBinding

class RegistrationActivity : AppCompatActivity() {
    private val binding by lazy { ActivityRegistrionBinding.inflate(layoutInflater) }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        
        setupTextWatchers()
        setupClickListeners()
    }
    
    private fun setupTextWatchers() {
        binding.etName.addTextChangedListener { binding.tilName.error = null }
        binding.etEmail.addTextChangedListener { binding.tilEmail.error = null }
        binding.etPassword.addTextChangedListener { 
            binding.tilPassword.error = null
            validatePasswordStrength(it.toString())
        }
        binding.etConfirmPassword.addTextChangedListener { binding.tilConfirmPassword.error = null }
    }
    
    private fun setupClickListeners() {
        binding.btnSignUp.setOnClickListener {
            if (validateInputs()) {
                showLoading(true)
                performRegistration()
            }
        }
        
        binding.tvLogin.setOnClickListener {
            finish()
        }
        
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun validateInputs(): Boolean {
        val name = binding.etName.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        val confirmPassword = binding.etConfirmPassword.text.toString().trim()
        
        if (name.isEmpty()) {
            binding.tilName.error = "Name is required"
            return false
        }
        
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
        
        if (password.length < 6) {
            binding.tilPassword.error = "Password must be at least 6 characters"
            return false
        }
        
        if (confirmPassword.isEmpty()) {
            binding.tilConfirmPassword.error = "Please confirm your password"
            return false
        }
        
        if (password != confirmPassword) {
            binding.tilConfirmPassword.error = "Passwords do not match"
            return false
        }
        
        return true
    }
    
    private fun validatePasswordStrength(password: String) {
        if (password.length < 6) {
            binding.tilPassword.helperText = "Password strength: Weak"
        } else if (password.length < 8) {
            binding.tilPassword.helperText = "Password strength: Medium"
        } else {
            binding.tilPassword.helperText = "Password strength: Strong"
        }
    }
    
    private fun performRegistration() {
        val name = binding.etName.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        
        if (DummyUsers.isEmailTaken(email)) {
            showLoading(false)
            binding.tilEmail.error = "Email already registered"
            return
        }
        
        // Simulate network delay
        binding.root.postDelayed({
            val user = User(
                email = email,
                password = password,
                name = name,
                bio = "Hey there! I'm using TaskFlow"
            )
            
            DummyUsers.addUser(user)
            Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
            
            // Return to login with the email pre-filled
            val intent = Intent(this, LoginActivity::class.java).apply {
                putExtra("registration_email", email)
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(intent)
            finish()
        }, 1500) // Simulate 1.5s delay
    }
    
    private fun showLoading(show: Boolean) {
        binding.btnSignUp.isEnabled = !show
        binding.progressBar.visibility = if (show) View.VISIBLE else View.GONE
        binding.tvSignUpText.visibility = if (show) View.GONE else View.VISIBLE
    }
}