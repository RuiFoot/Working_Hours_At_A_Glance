package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.databinding.FragmentLawBinding

class DetailFragment : Fragment() {

    private val viewModel: SharedViewModel by viewModels({ requireParentFragment() })
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedItem.observe(viewLifecycleOwner, Observer { selectedData ->
            // Use selectedData to update your UI in the DetailFragment
            binding.textViewMain.text = selectedData.main
            binding.textViewMiddle.text = selectedData.middle
            binding.textViewQuestion.text = selectedData.question
            binding.textViewAnswer.text = selectedData.answer
        })
    }
}