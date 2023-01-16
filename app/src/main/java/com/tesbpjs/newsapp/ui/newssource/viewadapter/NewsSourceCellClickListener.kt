package com.tesbpjs.newsapp.ui.newssource.viewadapter

import com.tesbpjs.newsapp.data.api.response.Source

interface NewsSourceCellClickListener {
    fun onCellClickListener(data:Source)
}