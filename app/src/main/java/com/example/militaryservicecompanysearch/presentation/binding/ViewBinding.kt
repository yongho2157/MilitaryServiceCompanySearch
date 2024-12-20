package com.example.militaryservicecompanysearch.presentation.binding

import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import com.example.militaryservicecompanysearch.presentation.jobsearch.JobSearchViewModel
import com.google.android.material.textfield.TextInputEditText

object ViewBinding {

    @JvmStatic
    @BindingAdapter("app:onTextChanged")
    fun setOnTextChanged(textInputEditText: TextInputEditText, viewModel: JobSearchViewModel) {
        textInputEditText.doOnTextChanged { text, _, _, _ ->
            text?.let { title ->
                viewModel.getRecruitmentNoticesByTitle(title.toString())
            }
        }
    }

}
