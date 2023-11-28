package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LawActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_law)

        val lawFAQDatabase = LawFAQDatabase.getInstance(this)

        lifecycleScope.launch(Dispatchers.IO) {
            val faqList =lawFAQDatabase.lawFAQDao().getAllFAQs()
            // 데이터 처리 또는 UI 업데이트 작업
            for (faq in faqList){
                Log.d("LawActivity","Question: ${faq.question}, Answer: ${faq.answer}")
                break
            }
        }

    }
}