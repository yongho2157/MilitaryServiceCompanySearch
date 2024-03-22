package com.example.militaryservicecompanysearch.presentation.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice


object RecruitmentNoticeBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:items")
    fun setList(recyclerView: RecyclerView, items: List<RecruitmentNotice>?) {
        items?.let {
            (recyclerView.adapter as RecruitmentNoticeAdapter).recruitmentNoticeList = items
        }
    }

}