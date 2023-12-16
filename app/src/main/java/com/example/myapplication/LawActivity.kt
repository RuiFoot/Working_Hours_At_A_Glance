package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.ActivityLawBinding
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