package com.tesbpjs.newsapp.ui.article.viewadapter

import com.tesbpjs.newsapp.data.api.response.Article

interface ArticleCellClickListener {
    fun onCellClickListener(data: Article)
}