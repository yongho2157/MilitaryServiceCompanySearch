package com.example.militaryservicecompanysearch.presentation.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.presentation.adapter.RecruitmentNoticeAdapter

object RecyclerViewBinding {

    @BindingAdapter("adapter")
    @JvmStatic
    fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        view.adapter = adapter
    }

    @BindingAdapter("submitList")
    @JvmStatic
    fun bindSubmitList(view: RecyclerView, itemList: List<RecruitmentNotice>) {
        val adapter = view.adapter as? RecruitmentNoticeAdapter
        adapter?.submitList(itemList.toMutableList())
    }
}