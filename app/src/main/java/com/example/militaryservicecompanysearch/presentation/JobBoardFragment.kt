package com.example.militaryservicecompanysearch.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.militaryservicecompanysearch.databinding.FragmentJobBoardBinding
import com.example.militaryservicecompanysearch.presentation.adapter.RecruitmentNoticeAdapter
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

        binding.chipSectorSelection.setOnClickListener {
            val action = JobBoardFragmentDirections.actionFragmentJobBoardToSectorSelectionFragment()
            findNavController().navigate(action)
        }

        binding.adapter?.setOnItemClickListener {
            val action = JobBoardFragmentDirections.actionFragmentJobBoardToFragmentJobDetail(it)
            findNavController().navigate(action)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.allSellUiState.collect {
                    binding.adapter?.submitData(it)
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
