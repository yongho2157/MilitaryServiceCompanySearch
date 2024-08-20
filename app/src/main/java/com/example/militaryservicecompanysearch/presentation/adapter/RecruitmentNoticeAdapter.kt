package com.example.militaryservicecompanysearch.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.militaryservicecompanysearch.databinding.RecruitmentNoticeItemBinding
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice

class RecruitmentNoticeAdapter : ListAdapter<RecruitmentNotice, RecruitmentNoticeViewHolder>(diffUtil) {

    private var onItemClickListener: ((RecruitmentNotice) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecruitmentNoticeViewHolder {
        val binding = RecruitmentNoticeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecruitmentNoticeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecruitmentNoticeViewHolder, position: Int) {
        val recruitmentNotice = getItem(position)
        holder.bind(recruitmentNotice)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(recruitmentNotice) }
        }
    }

    fun setOnItemClickListener(listener: (RecruitmentNotice) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RecruitmentNotice>() {
            override fun areItemsTheSame(
                oldItem: RecruitmentNotice, newItem: RecruitmentNotice
            ): Boolean {
                return oldItem.recruitmentNo == newItem.recruitmentNo
            }

            override fun areContentsTheSame(
                oldItem: RecruitmentNotice, newItem: RecruitmentNotice
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

}