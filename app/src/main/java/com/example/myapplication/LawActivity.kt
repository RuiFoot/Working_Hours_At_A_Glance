package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityLawBinding
import com.example.myapplication.ui.main.LawFragment
import com.example.myapplication.ui.main.WorkFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LawActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLawBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLawBinding.inflate(layoutInflater)

        setContentView(binding.root)

    }
}