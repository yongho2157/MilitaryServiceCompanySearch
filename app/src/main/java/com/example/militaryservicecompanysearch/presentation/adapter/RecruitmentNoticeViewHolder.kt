package com.example.militaryservicecompanysearch.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.militaryservicecompanysearch.databinding.RecruitmentNoticeItemBinding
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice

class RecruitmentNoticeViewHolder(
    private val binding: RecruitmentNoticeItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(recruitmentNotice: RecruitmentNotice) {
        binding.recruitmentNotice = recruitmentNotice
    }

}