package com.example.militaryservicecompanysearch.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.militaryservicecompanysearch.R
import com.example.militaryservicecompanysearch.databinding.FragmentSectorSelectionBinding
import com.google.android.material.chip.Chip

class SectorSelectionFragment : Fragment() {

    private var _binding: FragmentSectorSelectionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSectorSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCloseButton()
        setupSectorChips()
        observeSelectedSectors()
    }

    private fun setupSectorChips() {
        resources.getStringArray(R.array.sector_types).forEach { sector ->
            val chip = Chip(requireContext()).apply {
                text = sector
                isCheckable = true
                isCheckedIconVisible = false

                setOnClickListener {
                    if (isChecked) {
                        viewModel.addSector(sector)
                    } else {
                        viewModel.removeSector(sector)
                    }
                }
            }
            binding.chipGroup.addView(chip)
        }
    }

    private fun observeSelectedSectors() {
        viewModel.selectedSectors.observe(viewLifecycleOwner) { sectors ->
            updateChipsSelection(sectors)
        }
    }

    private fun updateChipsSelection(selectedSectors: List<String>) {
        for (i in 0 until binding.chipGroup.childCount) {
            val chip = binding.chipGroup.getChildAt(i) as? Chip
            chip?.let {
                val shouldBeChecked = selectedSectors.contains(it.text.toString())
                if (it.isChecked != shouldBeChecked) {
                    it.isChecked = shouldBeChecked
                }
            }
        }
    }

    private fun setupCloseButton() {
        binding.btnClose.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
