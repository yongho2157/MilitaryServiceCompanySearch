package com.example.militaryservicecompanysearch.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.militaryservicecompanysearch.databinding.FragmentJobSearchBinding
import com.example.militaryservicecompanysearch.presentation.adapter.RecruitmentNoticeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class JobSearchFragment : Fragment() {

    private var _binding: FragmentJobSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: JobSearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJobSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            vm = viewModel
            adapter = RecruitmentNoticeAdapter()
        }

        binding.adapter?.setOnItemClickListener {
            val action = JobSearchFragmentDirections.actionFragmentJobSearchToFragmentJobDetail(it)
            findNavController().navigate(action)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.recruitmentNoticeList.collectLatest {
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
