package com.project.newsapp.ui.article.viewadapter

import com.project.newsapp.data.api.response.Article

interface ArticleCellClickListener {
    fun onCellClickListener(data: Article)
}