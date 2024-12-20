package com.example.militaryservicecompanysearch.presentation.wishrecruitmentnotice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.militaryservicecompanysearch.databinding.FragmentWishRecruitmentNoticeBinding
import com.example.militaryservicecompanysearch.presentation.adapter.WishRecruitmentNoticeAdapter
import kotlinx.coroutines.launch


class WishRecruitmentNoticeFragment : Fragment() {

    private var _binding: FragmentWishRecruitmentNoticeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WishRecruitmentNoticeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWishRecruitmentNoticeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
            adapter = WishRecruitmentNoticeAdapter()
        }

        viewModel.getWishRecruitmentNotices()


        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.wishRecruitmentNoticeUiState.collect { uiState ->
                when (uiState) {
                    is WishRecruitmentNoticeUiState.Loading -> {
                        binding.contentLoadingProgressBar.show()
                    }
                    is WishRecruitmentNoticeUiState.Empty -> {
                        binding.contentLoadingProgressBar.hide()
                        binding.emptyTextView.visibility = View.VISIBLE
                    }
                    is WishRecruitmentNoticeUiState.HasRecruitmentNotices -> {
                        binding.contentLoadingProgressBar.hide()
                        binding.emptyTextView.visibility = View.GONE
                        binding.adapter?.submitList(uiState.wishRecruitmentNotices)
                    }
                }
            }
        }

        binding.adapter?.setOnItemClickListener {
            val action = WishRecruitmentNoticeFragmentDirections.actionFragmentWishRecruitmentNoticeToFragmentJobDetail(it)
            findNavController().navigate(action)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
