package com.example.militaryservicecompanysearch.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.militaryservicecompanysearch.databinding.RecruitmentNoticeItemBinding
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice

class RecruitmentNoticeAdapter : RecyclerView.Adapter<RecruitmentNoticeViewHolder>() {

     var recruitmentNoticeList: List<RecruitmentNotice> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecruitmentNoticeViewHolder {
        val binding = RecruitmentNoticeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecruitmentNoticeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return recruitmentNoticeList.size
    }

    override fun onBindViewHolder(holder: RecruitmentNoticeViewHolder, position: Int) {
        holder.bind(recruitmentNoticeList[position])
    }

}