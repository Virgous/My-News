package com.project.newsapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.project.newsapp.data.api.response.Article
import com.project.newsapp.data.api.response.Source

interface NewsRepository {
    fun getNewsBySourcePaging(source: String): LiveData<PagingData<Article>>

    suspend fun getNewsSourceByCategory(category:String):List<Source>
}