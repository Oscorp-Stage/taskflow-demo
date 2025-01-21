package com.taskflow.app.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.taskflow.app.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Setup account settings
        binding.tvEditProfile.setOnClickListener {
            Toast.makeText(context, "Edit Profile clicked", Toast.LENGTH_SHORT).show()
            // TODO: Implement profile editing
        }
        
        binding.tvChangePassword.setOnClickListener {
            Toast.makeText(context, "Change Password clicked", Toast.LENGTH_SHORT).show()
            // TODO: Implement password change
        }
        
        // Setup notifications toggle
        binding.switchNotifications.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(
                context,
                if (isChecked) "Notifications enabled" else "Notifications disabled",
                Toast.LENGTH_SHORT
            ).show()
            // TODO: Implement notifications toggle
        }
        
        // Setup logout
        binding.btnLogout.setOnClickListener {
            activity?.let {
                startActivity(Intent(it, LoginActivity::class.java))
                it.finish()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 