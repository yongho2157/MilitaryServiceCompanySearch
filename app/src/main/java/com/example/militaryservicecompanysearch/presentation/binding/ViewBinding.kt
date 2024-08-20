package com.example.militaryservicecompanysearch.presentation.binding

import androidx.appcompat.widget.SearchView
import androidx.databinding.BindingAdapter
import com.example.militaryservicecompanysearch.presentation.MainViewModel

object ViewBinding {

    @BindingAdapter("app:setOnQueryTextListener")
    @JvmStatic
    fun setOnQueryTextListener(searchView: SearchView, viewModel: MainViewModel) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { keyword ->
                    viewModel.getRecruitmentNoticesByTitle(keyword)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

}
