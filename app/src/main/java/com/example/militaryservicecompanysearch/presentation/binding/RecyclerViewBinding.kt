package com.example.militaryservicecompanysearch.presentation.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object RecyclerViewBinding {

    @BindingAdapter("adapter")
    @JvmStatic
    fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        view.adapter = adapter
    }
}
