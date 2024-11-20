package com.example.militaryservicecompanysearch.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.militaryservicecompanysearch.R
import com.example.militaryservicecompanysearch.databinding.FragmentSectorSelectionBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.chip.Chip
import kotlinx.coroutines.launch

class SectorSelectionFragment : Fragment() {

    private var _binding: FragmentSectorSelectionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()
    private val selectedChips = mutableSetOf<String>()

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

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.selectedSectors.collect { sectors ->
                    updateChipsSelection(sectors)
                }
            }
        }

        binding.resetSectorButton.setOnClickListener {
            resetSectors()
        }
        binding.submitSectorButton.setOnClickListener {
            submitSectors()
        }
    }

    private fun setupSectorChips() {
        resources.getStringArray(R.array.sector_types).forEach { sector ->
            val chip = Chip(requireContext()).apply {
                text = sector
                isCheckable = true
                isCheckedIconVisible = false

                // selector로 정의한 색상 적용
                chipBackgroundColor = ContextCompat.getColorStateList(
                    requireContext(),
                    R.color.chip_background_selector
                )

                // 텍스트 색상도 selector로 적용하고 싶다면
                setTextColor(
                    ContextCompat.getColorStateList(
                        requireContext(),
                        R.color.chip_text_selector
                    )
                )

                setOnClickListener {
                    if (isChecked) {
                        selectedChips.add(text.toString())
                    } else {
                        selectedChips.remove(text.toString())
                    }
                }
            }
            binding.chipGroup.addView(chip)
        }
    }

    private fun submitSectors() {
        viewModel.clearSector()
        selectedChips.forEach { sector ->
            viewModel.addSector(sector)
        }
        findNavController().popBackStack()
    }

    private fun resetSectors() {
        selectedChips.clear()
        for (i in 0 until binding.chipGroup.childCount) {
            val chip = binding.chipGroup.getChildAt(i) as? Chip
            chip?.isChecked = false
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

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)?.visibility =
            View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)?.visibility =
            View.VISIBLE
        _binding = null
    }

}

