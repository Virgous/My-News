package com.project.newsapp.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.project.newsapp.data.api.response.Article
import com.project.newsapp.data.repository.NewsRepository

class ArticleViewModel(private val newsRepository: NewsRepository):ViewModel() {
    fun getArticleBySource(sourceId: String):LiveData<PagingData<Article>>{
        return newsRepository.getNewsBySourcePaging(sourceId)
    }
}