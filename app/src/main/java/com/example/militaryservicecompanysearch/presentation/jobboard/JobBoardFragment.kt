package com.example.militaryservicecompanysearch.presentation.jobboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.militaryservicecompanysearch.R
import com.example.militaryservicecompanysearch.databinding.FragmentJobBoardBinding
import com.example.militaryservicecompanysearch.presentation.adapter.RecruitmentNoticeAdapter
import com.example.militaryservicecompanysearch.presentation.main.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class JobBoardFragment : Fragment() {

    private var _binding: FragmentJobBoardBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJobBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            vm = viewModel
            lifecycleOwner = this@JobBoardFragment
            adapter = RecruitmentNoticeAdapter()
        }

        binding.sectorSelection.setOnClickListener {
            val action =
                JobBoardFragmentDirections.actionFragmentJobBoardToSectorSelectionFragment()
            findNavController().navigate(action)
        }

        binding.adapter?.setOnItemClickListener {
            val action = JobBoardFragmentDirections.actionFragmentJobBoardToFragmentJobDetail(it)
            findNavController().navigate(action)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.allSellUiState.collectLatest {
                    binding.adapter?.submitData(it)
                }
            }
        }

        binding.militaryServiceTypeAutoCompleteTextView.doOnTextChanged { text, _, _, _ ->
            val selectedValue = text.toString()
            viewModel.setMilitaryServiceType(selectedValue)
            viewModel.getLocalRecruitmentNotices()
        }

        binding.personnelAutoCompleteTextView.doOnTextChanged { text, _, _, _ ->
            val selectedValue = text.toString()
            viewModel.setPersonnel(selectedValue)
            viewModel.getLocalRecruitmentNotices()
        }
    }

    override fun onResume() {
        super.onResume()

        val militaryServiceTypes = resources.getStringArray(R.array.military_service_types)
        val militaryServiceTypeAdapter = ArrayAdapter(requireContext(), R.layout.millitary_service_dropdown_menu_item, militaryServiceTypes)

        val personnelTypes = resources.getStringArray(R.array.personnel_types)
        val personnelTypeAdapter = ArrayAdapter(requireContext(), R.layout.millitary_service_dropdown_menu_item, personnelTypes)

        binding.militaryServiceTypeAutoCompleteTextView.setAdapter(militaryServiceTypeAdapter)
        binding.personnelAutoCompleteTextView.setAdapter(personnelTypeAdapter)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
