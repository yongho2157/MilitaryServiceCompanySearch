package com.example.militaryservicecompanysearch.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.militaryservicecompanysearch.databinding.RecruitmentNoticeItemBinding
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice

class RecruitmentNoticeAdapter(
    private val listener: RecyclerViewEvent
) : RecyclerView.Adapter<RecruitmentNoticeViewHolder>() {

     private var recruitmentNoticeList = mutableListOf<RecruitmentNotice>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecruitmentNoticeViewHolder {
        val binding = RecruitmentNoticeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecruitmentNoticeViewHolder(binding, listener)
    }

    override fun getItemCount(): Int {
        return recruitmentNoticeList.size
    }

    override fun onBindViewHolder(holder: RecruitmentNoticeViewHolder, position: Int) {
        holder.bind(recruitmentNoticeList[position])
    }

    fun addAll(data: List<RecruitmentNotice>) {
        recruitmentNoticeList.clear()
        recruitmentNoticeList.addAll(data)
        notifyDataSetChanged()
    }

    interface RecyclerViewEvent {
        fun onItemClick(position: Int)
    }

}