package com.example.militaryservicecompanysearch.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.militaryservicecompanysearch.databinding.RecruitmentNoticeItemBinding
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice

class RecruitmentNoticeViewHolder(private val binding: RecruitmentNoticeItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(recruitmentNotice: RecruitmentNotice) {
        with(binding) {
            textViewCompanyName.text = recruitmentNotice.companyName
            textViewTitle.text = recruitmentNotice.title
            textViewJobPositionAndLocation.text = recruitmentNotice.jobPosition + " | " + recruitmentNotice.location

        }
    }

}