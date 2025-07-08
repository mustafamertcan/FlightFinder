package com.example.flight.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flight.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        // My Bookings
        binding.myBookingsLayout.setOnClickListener {
            // TODO: Navigate to My Bookings screen
        }

        // Check-in
        binding.checkInLayout.setOnClickListener {
            // TODO: Navigate to Check-in screen
        }

        // Flight Status
        binding.flightStatusLayout.setOnClickListener {
            // TODO: Navigate to Flight Status screen
        }
    }
} 