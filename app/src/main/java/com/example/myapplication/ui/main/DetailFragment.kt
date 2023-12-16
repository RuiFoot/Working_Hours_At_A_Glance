package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import com.example.myapplication.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("YourTag", "Selected Data: ${viewModel.selectedItem.value}")

        viewModel.selectedItem.observe(viewLifecycleOwner, Observer { selectedItem ->
            // Use selectedData to update your UI in the DetailFragment
            binding.textViewMain.text = selectedItem.main
            binding.textViewMiddle.text = selectedItem.middle
            binding.textViewQuestion.text = selectedItem.question
            binding.textViewAnswer.text = selectedItem.answer
            binding.invalidateAll()
        })
        binding.exit.setOnClickListener {
            // Use the Navigation component to navigate back
            view.findNavController().navigateUp()
        }
    }
}