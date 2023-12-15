package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 번들에 저장된 savedInstanceState가 있으면 이 state로 만든다.

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // 버튼2 : 노동법 검색을 할 수 있는 액티비티로 가는 intent
        binding.btnCon.setOnClickListener {
            val intent3 = Intent(this@MainActivity, LawActivity::class.java)
            startActivity(intent3)
        }
    }
}

