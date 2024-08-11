package com.example.militaryservicecompanysearch.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.militaryservicecompanysearch.databinding.RecruitmentNoticeItemBinding
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice

class RecruitmentNoticeAdapter : ListAdapter<RecruitmentNotice, RecruitmentNoticeViewHolder>(diffUtil) {

    private var recruitmentNoticeList = mutableListOf<RecruitmentNotice>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecruitmentNoticeViewHolder {
        val binding =
            RecruitmentNoticeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    override fun submitList(list: List<RecruitmentNotice>?) {
        super.submitList(list)
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
                return oldItem.hashCode() == newItem.hashCode()
            }

        }
    }

}