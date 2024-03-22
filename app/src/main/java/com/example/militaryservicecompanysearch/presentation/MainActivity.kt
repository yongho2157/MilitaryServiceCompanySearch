package com.example.militaryservicecompanysearch.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.militaryservicecompanysearch.databinding.ActivityMainBinding
import com.example.militaryservicecompanysearch.presentation.adapter.RecruitmentNoticeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mainViewModel.getRecruitmentNotices()

        binding.recyclerViewRecruitmentNotice.adapter = RecruitmentNoticeAdapter()
    }
}