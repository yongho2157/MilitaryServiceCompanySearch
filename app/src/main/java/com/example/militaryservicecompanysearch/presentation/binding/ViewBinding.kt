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
                query?.let { title ->
                    viewModel.getRecruitmentNoticesByTitle(title)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { title ->
                    viewModel.getRecruitmentNoticesByTitle(title)
                }
                return true
            }

        })
    }

}
