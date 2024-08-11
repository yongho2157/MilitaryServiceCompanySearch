package com.example.militaryservicecompanysearch.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.militaryservicecompanysearch.databinding.FragmentJobBoardBinding
import com.example.militaryservicecompanysearch.presentation.adapter.RecruitmentNoticeAdapter

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
            adapter = RecruitmentNoticeAdapter()
        }

//        viewModel.getRecruitmentNotices()


//        val recruitmentNoticeAdapter = RecruitmentNoticeAdapter()
//        recruitmentNoticeAdapter.setOnItemClickListener {
//            val action = JobBoardFragmentDirections.actionFragmentJobBoardToFragmentJobDetail(it)
//            findNavController().navigate(action)
//        }
//
//        binding.recyclerViewRecruitmentNotice.adapter = recruitmentNoticeAdapter
//
//        viewModel.recruitmentNoticeList.observe(requireActivity()) {
//            recruitmentNoticeAdapter.addAll(it)
//        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}