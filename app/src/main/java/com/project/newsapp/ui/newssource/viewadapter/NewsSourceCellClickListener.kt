package com.project.newsapp.ui.newssource.viewadapter

import com.project.newsapp.data.api.response.Source

interface NewsSourceCellClickListener {
    fun onCellClickListener(data:Source)
}