package com.taskflow.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.taskflow.app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Set welcome message
        binding.tvWelcome.text = "Welcome back!"
        
        // Setup task card
        binding.btnAddTask.setOnClickListener {
            Toast.makeText(context, "Add Task clicked", Toast.LENGTH_SHORT).show()
            // TODO: Implement task addition
        }
        
        // Setup progress indicator
        binding.progressIndicator.progress = 65 // Example progress
        
        // Setup reminders
        binding.tvNoReminders.text = "No upcoming reminders"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 