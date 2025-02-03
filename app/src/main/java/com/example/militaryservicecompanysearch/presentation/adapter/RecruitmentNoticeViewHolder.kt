package com.example.militaryservicecompanysearch.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.militartservicecompanysearch.core.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.databinding.RecruitmentNoticeItemBinding

class RecruitmentNoticeViewHolder(
    private val binding: RecruitmentNoticeItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(recruitmentNotice: RecruitmentNotice) {
        binding.recruitmentNotice = recruitmentNotice
    }

}
