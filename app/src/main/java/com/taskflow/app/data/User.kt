package com.taskflow.app.data

import android.util.Log

data class User(
    val email: String,
    val password: String,
    val name: String = "",
    val profileImage: String = "",
    val bio: String = ""
)

object DummyUsers {
    private val users = mutableListOf<User>()

    init {
        // Add some default users with more details
        addUser(User(
            email = "test@test.com",
            password = "password123",
            name = "Test User",
            bio = "I love staying organized and productive!"
        ))
        addUser(User(
            email = "demo@demo.com",
            password = "demo123",
            name = "Demo User",
            bio = "Task management enthusiast"
        ))
    }
    
    fun addUser(user: User) {
        users.add(user)
        Log.d("DummyUsers", "Added user: ${user.email}")
        Log.d("DummyUsers", "Current users: ${users.size}")
    }
    
    fun validateUser(email: String, password: String): Boolean {
        Log.d("DummyUsers", "Attempting login with email: $email")
        Log.d("DummyUsers", "Current users in system: ${users.size}")
        val isValid = users.any { it.email == email && it.password == password }
        Log.d("DummyUsers", "Login success: $isValid")
        return isValid
    }
    
    fun isEmailTaken(email: String): Boolean {
        val isTaken = users.any { it.email == email }
        Log.d("DummyUsers", "Checking if email taken: $email, Result: $isTaken")
        return isTaken
    }
    
    fun getUserByEmail(email: String): User? {
        return users.find { it.email == email }
    }
    
    fun updateUser(user: User) {
        val index = users.indexOfFirst { it.email == user.email }
        if (index != -1) {
            users[index] = user
            Log.d("DummyUsers", "Updated user: ${user.email}")
        }
    }
    
    // Helper function to get all registered users (for debugging)
    fun getAllUsers(): List<User> = users.toList()
} 