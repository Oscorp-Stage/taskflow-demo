package com.taskflow.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.taskflow.app.data.DummyUsers
import com.taskflow.app.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private var userEmail: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Get user data
        userEmail?.let { email ->
            DummyUsers.getUserByEmail(email)?.let { user ->
                binding.tvName.text = user.name
                binding.tvEmail.text = user.email
                
                // Set stats (dummy data for now)
                binding.tvTaskCount.text = "12"
                binding.tvCompletedCount.text = "8"
                binding.tvPendingCount.text = "4"
            }
        }
        
        // Setup edit profile button
        binding.btnEditProfile.setOnClickListener {
            Toast.makeText(context, "Edit Profile clicked", Toast.LENGTH_SHORT).show()
            // TODO: Implement profile editing
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    companion object {
        fun newInstance(email: String?) = ProfileFragment().apply {
            userEmail = email
        }
    }
} 