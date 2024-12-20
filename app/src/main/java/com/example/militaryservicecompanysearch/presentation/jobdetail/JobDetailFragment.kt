package com.example.militaryservicecompanysearch.presentation.jobdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.militaryservicecompanysearch.R
import com.example.militaryservicecompanysearch.databinding.FragmentJobDetailBinding
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

class JobDetailFragment : Fragment() {

    private var _binding: FragmentJobDetailBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<JobDetailFragmentArgs>()

    private val viewModel: JobDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJobDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recruitmentNotice = args.RecruitmentNotice
        val recruitmentNotice = binding.recruitmentNotice as RecruitmentNotice

        viewModel.setIsBookmarked(recruitmentNotice.isBookmarked)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isBookmarked.collect { isBookmarked ->
                if (isBookmarked) {
                    binding.bookmarkImageButton.setImageResource(R.drawable.baseline_bookmark_24)
                } else {
                    binding.bookmarkImageButton.setImageResource(R.drawable.baseline_bookmark_border_32)
                }
            }
        }

        binding.bookmarkImageButton.setOnClickListener {
            viewModel.updateBookmarkStatus(recruitmentNotice.recruitmentNo!!)
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
