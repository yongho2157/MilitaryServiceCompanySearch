package com.example.militaryservicecompanysearch.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.militartservicecompanysearch.core.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.databinding.RecruitmentNoticeItemBinding

class WishRecruitmentNoticeAdapter : ListAdapter<RecruitmentNotice, RecruitmentNoticeViewHolder>(diffUtil) {

    private var onItemClickListener: ((RecruitmentNotice) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecruitmentNoticeViewHolder {
        val binding = RecruitmentNoticeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecruitmentNoticeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecruitmentNoticeViewHolder, position: Int) {
        val recruitmentNotice = getItem(position)
        if (recruitmentNotice != null) {
            holder.bind(recruitmentNotice)
        }
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                if (recruitmentNotice != null) {
                    it(recruitmentNotice)
                }
            }
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
