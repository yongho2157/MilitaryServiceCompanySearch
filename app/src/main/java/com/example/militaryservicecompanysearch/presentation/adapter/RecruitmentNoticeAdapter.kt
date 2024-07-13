package com.example.militaryservicecompanysearch.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.militaryservicecompanysearch.databinding.RecruitmentNoticeItemBinding
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice

class RecruitmentNoticeAdapter : RecyclerView.Adapter<RecruitmentNoticeViewHolder>() {

     private var recruitmentNoticeList = mutableListOf<RecruitmentNotice>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecruitmentNoticeViewHolder {
        val binding = RecruitmentNoticeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecruitmentNoticeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return recruitmentNoticeList.size
    }

    override fun onBindViewHolder(holder: RecruitmentNoticeViewHolder, position: Int) {
        val recruitmentNotice = recruitmentNoticeList[position]
        holder.bind(recruitmentNotice)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(recruitmentNotice) }
        }
    }

    private var onItemClickListener: ((RecruitmentNotice) -> Unit)? = null
    fun setOnItemClickListener(listener: (RecruitmentNotice) -> Unit) {
        onItemClickListener = listener
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