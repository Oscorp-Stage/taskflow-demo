package com.taskflow.app.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.taskflow.app.data.DummyUsers
import com.taskflow.app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
        // Log the number of registered users when activity starts
        Log.d("LoginActivity", "Number of registered users: ${DummyUsers.getAllUsers().size}")
        
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            
            Log.d("LoginActivity", "Login attempt - Email: $email")
            
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            if (DummyUsers.validateUser(email, password)) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                // Check if the email exists to provide more specific error message
                if (DummyUsers.isEmailTaken(email)) {
                    Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Email not registered", Toast.LENGTH_SHORT).show()
                }
            }
        }
        
        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }
}