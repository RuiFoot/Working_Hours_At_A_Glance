package com.example.myapplication.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.myapplication.LawFAQ
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLawBinding
class LawFragment : Fragment() {

    companion object {
        fun newInstance() = LawFragment()
    }

    private val viewModel: LawViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by viewModels({ requireActivity() })
    private lateinit var binding: FragmentLawBinding
    private var selectedSearchMain: String = ""
    private var selectedSearchMiddle: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLawBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Main 스피너 초기화
        val searchMain: Spinner = binding.searchMain
        val searchMiddle: Spinner = binding.searchMiddle
        val searchButton: Button = binding.searchButton
        val searchEditText: EditText = binding.itemIndexEdit

        // Main 스피너의 아이템 배열
        val mainItems = arrayOf("전체", "해고", "임금")

        // Main 스피너 어댑터 설정
        val mainAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, mainItems)
        mainAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        searchMain.adapter = mainAdapter
        mainAdapter.notifyDataSetChanged()

        // Main 스피너 선택 리스너 설정
        searchMain.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View?, position: Int, id: Long) {
                // Main 스피너에서 선택한 항목에 따라 Middle 스피너의 아이템 배열을 변경
                updateMiddleSpinner(position)

                // 선택된 아이템 가져오기
                selectedSearchMain = parentView.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                // 아무것도 선택되지 않았을 때의 동작
            }
        }
        // Set up an item selected listener for the searchMiddle Spinner
        searchMiddle.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Get the selected item
                selectedSearchMiddle = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle nothing selected if needed
            }
        }
        searchButton.setOnClickListener {
            val queryMain = selectedSearchMain
            val queryMiddle = selectedSearchMiddle
            val queryEditText = searchEditText.text.toString()

            // Call the search method in the ViewModel
            viewModel.search(queryMain, queryMiddle, queryEditText)
        }

        // Observe the search results and update UI accordingly
        viewModel.searchResults.observe(viewLifecycleOwner, Observer { results ->
            // Update UI with search results, for example, update the ListView or RecyclerView
            // results is a list of YourDataModel objects returned from the search
            updateListView(results)
        })

    }
    private fun updateMiddleSpinner(mainPosition: Int) {
        // Middle 스피너의 아이템 배열을 Main 스피너의 선택에 따라 동적으로 변경
        val middleItems = when (mainPosition) {
            0 -> arrayOf("전체")
            1 -> arrayOf("권고사직", "당연퇴직","부당해고","전보·전근","전출·전적","정리해고","직권면직"
                ,"직위해제","징계", "통상해고","퇴직","퇴직금","폐업","합의해지","해고일반","해고사유 서면통지"
                ,"해고예고","해고의 구제","해고의 제한","휴직","기타")
            2 -> arrayOf("감급 및 감봉","노동 일반","법정수당",
                "비전형근로관계","실업급여","임금일반","임금채권",
                "최저임금","통상임금","퇴직금","퇴직연금","평균임금","포괄임금제도","휴업수당",
                "기타")
            else -> arrayOf()
        }
        // Middle 스피너 어댑터 설정
        val middleAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, middleItems)
        middleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.searchMiddle.adapter = middleAdapter
        middleAdapter.notifyDataSetChanged()
    }
    private fun updateListView(searchResults: List<LawFAQ>) {
        val dataList = searchResults.map {
            DataModel(it.main.toString(), it.middle.toString(), it.question.toString())
        }
        // Assuming you have a custom adapter for your ListView
        val LawAdapter = LawAdapter(requireContext(), dataList)
        val listView: ListView = binding.listView
        listView.adapter = LawAdapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = searchResults[position]  // Get the selected LawFAQ directly

            // Log selectedData
            Log.d("YourTag", "Selected Data: $selectedItem")

            // Create a bundle with data to pass to DetailFragment
            sharedViewModel.setSelectedItem(selectedItem)

            view?.findNavController()?.navigate(R.id.action_lawFragment_to_detailFragment)


        }
    }
}