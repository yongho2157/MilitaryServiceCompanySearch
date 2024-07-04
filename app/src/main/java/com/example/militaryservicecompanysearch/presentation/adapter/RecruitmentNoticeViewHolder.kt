package com.example.militaryservicecompanysearch.presentation.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.militaryservicecompanysearch.databinding.RecruitmentNoticeItemBinding
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice

class RecruitmentNoticeViewHolder(
    private val binding: RecruitmentNoticeItemBinding,
    private val listener: RecruitmentNoticeAdapter.RecyclerViewEvent
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    init {
        binding.root.setOnClickListener(this)
    }

    fun bind(recruitmentNotice: RecruitmentNotice) {
        binding.recruitmentNotice = recruitmentNotice
    }

    override fun onClick(v: View?) {
        Log.d("결과", "ViewHolder-onClick()")
        val position = adapterPosition

        if (position != RecyclerView.NO_POSITION) {
            listener.onItemClick(position)
        }

    }

}